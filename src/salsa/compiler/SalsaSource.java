package salsa.compiler;

public abstract class SalsaSource {
    
    private int line = -1;
    
    private String salsaSource = "";
    
    private static int errorNum = 0;

    public void setLine(int line) {
        this.line = line;
    }

    public int getLine() {
        return line;
    }
    
    
    public void setSalsaSource(String src) {
        salsaSource = src;
    }


    public String getSalsaSource() {
        return salsaSource;
    }
    
    public String getOutputPrefix() {
        return ("line " + line + ": ");
    }
    
    public void log(String info) {
        System.err.println(this.getOutputPrefix() + info + "\n\t" + this.getSalsaSource() + "");
        errorNum++;
    }
    
    public static int getErrorNum() {
        return errorNum;
    }
    
    public static void resetErrorNum() {
        errorNum = 0;
    }
}
