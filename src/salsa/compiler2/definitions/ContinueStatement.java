package salsa.compiler2.definitions;

public class ContinueStatement extends Statement {

    @Override
    public String toJavaCode(String identation) {
        return "continue; ";
    }

}
