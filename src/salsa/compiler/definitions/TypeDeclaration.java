package salsa.compiler.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import salsa.compiler.SalsaNode;
import salsa.compiler.SalsaSource;


public abstract class TypeDeclaration extends SalsaSource implements SalsaNode{
    protected String name = "";
    protected String extendsName = "";
    protected String attributes = ""; 
    protected List<String> implementNames = new ArrayList<String>();   
    protected List<String> imports;
    protected String moduleName = "";
    protected String absoluteName = "";    
    

    protected List<StateVariableDeclaration> stateVariableDeclarations = new ArrayList<StateVariableDeclaration>();

    protected Map<String, MessageHandlerDeclaration> messageHandlers = new HashMap<String, MessageHandlerDeclaration>();

    protected Map<String, ConstructorDeclaration> constructors = new HashMap<String, ConstructorDeclaration>();
    
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

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
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

    public void addStateVariableDeclaration(StateVariableDeclaration sd) {
        stateVariableDeclarations.add(sd);
    }

    private void addMessageHanderDeclaration(MessageHandlerDeclaration mh) {
        messageHandlers.put(mh.getSignature(), mh);
    }

    private void addConstructorDeclaration(ConstructorDeclaration c) {
        constructors.put(c.getSignature(),c);
    }      
    
    public MessageHandlerDeclaration getMessageHandler(String signature) {
        return messageHandlers.get(signature);
    }
    
    public ConstructorDeclaration getConstructor(String signature) {
        return constructors.get(signature);
    }
    

    public void addMethodDeclaration(MethodDeclaration m) {
        if (m instanceof ConstructorDeclaration)
            this.addConstructorDeclaration((ConstructorDeclaration)m);
        else if (m instanceof MessageHandlerDeclaration) 
            this.addMessageHanderDeclaration((MessageHandlerDeclaration)m);
    }
    

    @Override
    public boolean analyze(SalsaNode parent) {

        for (Iterator<StateVariableDeclaration> it = stateVariableDeclarations
                .iterator(); it.hasNext();) {
            StateVariableDeclaration svd = it.next();
            List<VariableDeclaration> vds = svd.getVariableDeclarations();
            for (Iterator<VariableDeclaration> it2 = vds.iterator(); it2
                    .hasNext();) {
                it2.next().analyze(this);
            }
        }
        
        for (Iterator<ConstructorDeclaration> it = constructors.values()
                .iterator(); it.hasNext();) {
            it.next().analyze(this);
        }

        for (Iterator<MessageHandlerDeclaration> it = messageHandlers.values()
                .iterator(); it.hasNext();) {
            it.next().analyze(this);
        }
        return true;
    }
}
