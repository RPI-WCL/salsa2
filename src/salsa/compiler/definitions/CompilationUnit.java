/*
	Code generation for the following grammar segment:

	CompilationUnit := 
		[ModuleDeclaration()] 
		(ImportDeclaration())* 
		[BehaviorDeclarationAttributes()]
		( BehaviorDeclaration() | InterfaceDeclaration() )
 */

package salsa.compiler.definitions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;

public class CompilationUnit extends SalsaSource implements SalsaNode {

    private List<String> imports;
    
    private String moduleName;

    private List<TypeDeclaration> typeDeclarations;
    
    private String sourceFileName = "";
    
    private String sourceDirName = "";
    
//    private static Map<String, SymbolType> knownTypes; 
    
    public CompilationUnit() {
        imports = new ArrayList<String>();
        typeDeclarations = new ArrayList<TypeDeclaration>();
    }

    public List<String> getImports() {
        return imports;
    }

    public void addImport(String importName) {
        this.imports.add(importName);
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<TypeDeclaration> getTypeDeclarations() {
        return typeDeclarations;
    }

    public void addTypeDeclaration(TypeDeclaration typeDeclaration) {
        this.typeDeclarations.add(typeDeclaration);
    }
    
    private String getHeaderCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        if (moduleName != null)
            sb.append(identation).append("package ").append(moduleName).append(";\n");
        sb.append("\n");
        for (Iterator<String> it = imports.iterator(); it.hasNext();) {
            sb.append(identation).append("import ").append(it.next()).append(";\n");
        }
        sb.append(identation).append("import salsa.lang.*").append(";\n");
        sb.append(identation).append("import salsa.lang.fullcopy.DeepCopy").append(";\n");
        sb.append(identation).append("import java.util.*").append(";\n");
        sb.append("\n");
        return sb.toString();
    }
    
    public String toJavaRefCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getHeaderCode(identation));
        
        for (Iterator<TypeDeclaration> it = typeDeclarations.iterator(); it.hasNext();) {
            TypeDeclaration td = it.next();
            if (td instanceof BehaviorDeclaration) {
                sb.append(identation).append(((BehaviorDeclaration)td).toJavaRefCode(identation));
            }
        }
        
        return sb.toString();
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getHeaderCode(identation));
        
        for (Iterator<TypeDeclaration> it = typeDeclarations.iterator(); it.hasNext();) {
            sb.append(identation).append(it.next().toJavaCode(identation));
        }
        
        return sb.toString();
    }
        

    @Override
    public boolean analyze(SalsaNode parent) {
        // TODO Auto-generated method stub
        for (Iterator<TypeDeclaration> it = typeDeclarations.iterator(); it.hasNext();) {
            it.next().analyze(this);
        }
        return true;
    }
    
    
    
    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
        int i = sourceFileName.lastIndexOf(File.separator);
        if (i < 0)
            this.sourceDirName = ".";
        else {
            this.sourceDirName = sourceFileName.substring(0, i);
        }
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public List<String> generateJavaCode() throws IOException {
        List<String> generatedFiles = new ArrayList<String>();
        String header = this.getHeaderCode("");
        for (Iterator<TypeDeclaration> it = typeDeclarations.iterator(); it.hasNext();) {
            TypeDeclaration td = it.next();
            if (td instanceof BehaviorDeclaration) {
                BehaviorDeclaration bd = (BehaviorDeclaration)td;
                String refFileName = sourceDirName + File.separator + bd.getName() + ".java";
                writeFile(refFileName, header + bd.toJavaRefCode(""));
                String stateFileName = sourceDirName + File.separator + td.getName() + "State.java";
                writeFile(stateFileName, header + bd.toJavaCode(""));
                generatedFiles.add(refFileName);
                generatedFiles.add(stateFileName);
            } else if (td instanceof ClassDeclaration) {
                String classFileName = sourceDirName + File.separator + td.getName() + ".java";
                writeFile(classFileName, header + td.toJavaCode(""));
                generatedFiles.add(classFileName);
            }
        }
        return generatedFiles;
    }
    
    private void writeFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
        if (!file.exists())
            file.createNewFile();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(content.getBytes());
        fos.close();
    }
}
