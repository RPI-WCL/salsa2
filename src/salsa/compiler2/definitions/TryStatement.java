package salsa.compiler2.definitions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class TryStatement extends Statement {
    
    private Block tryBlock; 
    
    private List<Block> catchBlocks = new ArrayList<Block>();
    
    private List<FormalParameter> fps = new ArrayList<FormalParameter>();
    
    private Block finallyBlock;

    public void setTryBlock(Block b1) {
        this.tryBlock = b1;
    }

    public void addCatchBlock(Block b2) {
        catchBlocks.add(b2);
    }

    public void addCatchFP(FormalParameter fp) {
        fps.add(fp);
    }

    public void setFinallyBlock(Block b3) {
        this.finallyBlock = b3;
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        sb.append(identation).append("try \n");
        sb.append(tryBlock.toJavaCode(identation));
        for (int i = 0; i < catchBlocks.size(); i++) {
            sb.append(identation).append("catch (").append(fps.get(i).toJavaCode("")).append(")\n");
            sb.append(catchBlocks.get(i).toJavaCode(identation));
        }
        if (finallyBlock != null) {
            sb.append(identation).append("finally \n");
            sb.append(finallyBlock.toJavaCode(identation));
        }
        return sb.toString();
    }

    @Override
    public void setInJoinBlock(boolean isInJoinBlock) {
        tryBlock.setJoinBlock(isInJoinBlock);
        if(finallyBlock != null)
            finallyBlock.setJoinBlock(isInJoinBlock);
        for(Block b : catchBlocks)
            b.setJoinBlock(isInJoinBlock);
        super.setInJoinBlock(isInJoinBlock);
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv,
            Map<String, SymbolType> knownTypes) {
        tryBlock.analyze(parent, typeEnv, knownTypes);
        for (int i = 0; i < catchBlocks.size(); i++) {
            Map<String, SymbolType> te = new HashMap<String, SymbolType>(typeEnv);
            fps.get(i).analyze(parent, te, knownTypes);
            catchBlocks.get(i).analyze(parent, te, knownTypes);
        }
        if (finallyBlock != null)
            finallyBlock.analyze(parent, typeEnv, knownTypes);
        return super.analyze(parent, typeEnv, knownTypes);
    }
    
    
}
