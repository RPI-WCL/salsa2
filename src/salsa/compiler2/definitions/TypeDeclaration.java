package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import salsa.compiler2.CompilerHelper;
import salsa.compiler2.SalsaNode;
import salsa.compiler2.SalsaSource;
import salsa.compiler2.SymbolField;
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
    
    private int declarationType = -1;
    
    public static final int ACTOR_TYPE = 1;
    
    public static final int CLASS_TYPE = 2;
    
    public static final int INTERFACE_TYPE = 3;
    
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

    public String getModifiers() {
        return modifiers;
    }

    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
    }
    
    public int getDeclarationType() {
        return declarationType;
    }

    public void setDeclarationType(int declarationType) {
        this.declarationType = declarationType;
    }

    public List<String> getImplementNames() {
        return implementNames;
    }

    public void setImplementNames(List<String> implementNames) {
        this.implementNames = implementNames;
    }

    public void addFieldVariableDeclaration(FieldVariableDeclaration sd) {
        fieldVariableDeclarations.add(sd);
    }


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

    public void analyzeMethod(Map<String, SymbolType> knownTypes) {
        SymbolType st = CompilerHelper.getSymbolTypeByName(absoluteName);
        for (ConstructorDeclaration cons : constructors) {
            st.addMethod(cons.getSymbolMethod(knownTypes));
        }

        for (MethodDeclaration md : methodDeclaration) {
            st.addMethod(md.getSymbolMethod(knownTypes));
        }
        //TODO need to consider if it is an object
        String superTypeName = "salsa.wwc.lang.ActorRef";
        if (!extendsName.equals("")) {
            superTypeName = extendsName;
        }
        SymbolType superType = CompilerHelper.getSymbolTypeByName(superTypeName);
        if (superType == null) {
            log("Unknown type " + superTypeName);
        } else {
            st.setSuperType(superType);
            st.addField(superType.getFields());
            st.addMethod(superType.getMethods());
        }
        
        for (String impl : implementNames) {
            SymbolType interfaceType = CompilerHelper.getSymbolTypeByName(impl);
            if (interfaceType == null)
                log("Unknown type " + impl);
            else 
                st.addInterfaceType(interfaceType);
        }
    
    }
}
