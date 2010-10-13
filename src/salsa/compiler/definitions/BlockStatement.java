package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;

public class BlockStatement extends Statement {

    Block block;
    
    public BlockStatement(Block block) {
        this.block = block;
    }

    @Override
    public String toJavaCode(String identation) {
        return block.toJavaCode(identation);
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        block.analyze(this);
        return true;
    }


    private int line = -1;
    @Override
    public void setLine(int line) {
        this.line = line;
    }
    @Override
    public int getLine() {
        return line;
    }
    
    private String salsaSource = "";
    
    @Override
    public void setSalsaSource(String src) {
        salsaSource = src;
    }

    @Override
    public String getSalsaSource() {
        return salsaSource;
    }
    
}
