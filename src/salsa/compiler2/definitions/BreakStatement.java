package salsa.compiler2.definitions;

public class BreakStatement extends Statement {

    @Override
    public String toJavaCode(String identation) {
        return "break;";
    }

}
