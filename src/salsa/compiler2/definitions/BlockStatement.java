package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

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
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
        super.analyze(parent, typeEnv, knownTypes);
        block.analyze(this, typeEnv, knownTypes);
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
