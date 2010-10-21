package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolType;


public abstract class TypeDeclaration extends SalsaSource implements SalsaNode{
    protected String name = "";
    protected String extendsName = "";
    protected String modifiers = ""; 
    protected List<String> implementNames = new ArrayList<String>();   
    protected List<String> imports;
    protected String moduleName = "";
    protected String absoluteName = "";    
    protected SymbolType symbolType = null;

    protected List<FieldVariableDeclaration> fieldVariableDeclarations = new ArrayList<FieldVariableDeclaration>();

    protected List<MethodDeclaration> methodDeclaration = new ArrayList<MethodDeclaration>();

    protected List<ConstructorDeclaration> constructors = new ArrayList<ConstructorDeclaration>();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtendsName() {
        return extendsName;
    }

    public void setExtendsName(String extendsName) {
        this.extendsName = extendsName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
        setAbsoluteName(moduleName + "." + name);
    }

    public String getAbsoluteName() {
        return absoluteName;
    }

    public void setAbsoluteName(String absoluteName) {
        this.absoluteName = absoluteName;
    }
    

    public void setSymbolType(SymbolType symbolType) {
        this.symbolType = symbolType;
    }

    public void addFieldVariableDeclaration(FieldVariableDeclaration sd) {
        fieldVariableDeclarations.add(sd);
    }

//    private void addMessageHanderDeclaration(MessageHandlerDeclaration mh) {
//        methodDeclaration.add(mh);
//    }

    private void addConstructorDeclaration(ConstructorDeclaration c) {
        constructors.add(c);
    }      
    
    public void addMethodDeclaration(MethodDeclaration m) {
        if (m instanceof ConstructorDeclaration)
            this.addConstructorDeclaration((ConstructorDeclaration)m);
        else 
            methodDeclaration.add(m);
    }
    

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        for (FieldVariableDeclaration fv : fieldVariableDeclarations) {
            for (VariableDeclaration vd : fv.getVariableDeclarations()) {
                vd.analyze(this, typeEnv, knownTypes);
            }
        }

        for (ConstructorDeclaration cons : constructors) {
            cons.analyze(this, new HashMap<String, SymbolType>(typeEnv), knownTypes);
        }

        for (MethodDeclaration md : methodDeclaration) {
            md.analyze(this, new HashMap<String, SymbolType>(typeEnv), knownTypes);
        }
        return true;
    }
}
