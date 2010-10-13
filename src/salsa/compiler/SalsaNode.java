package salsa.compiler;


public interface SalsaNode {
    
    public String toJavaCode(String identation);
    
    public boolean analyze(SalsaNode parent);

}
