package salsa.compiler2.definitions;

import java.util.Map;

import salsa.compiler2.SalsaNode;
import salsa.compiler2.SymbolType;

public class JoinBlockStatement extends Statement implements SalsaNode {
    
    Block block;

    public JoinBlockStatement(Block block) {
        this.block = block;
        block.setJoinBlock(true);
        this.setSendMessage(true);
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb =  new StringBuilder();
        sb.append("\n").append(identation).append("// begin joinblock\n");
        sb.append(identation).append("List _tokenList = new ArrayList();");
        sb.append(block.toJavaCode(identation));
        sb.append("\n");
        sb.append(identation).append("Object[] _tokens = _tokenList.toArray();\n");
        sb.append(identation).append("token = send(self,self,-1,\"joinHelper\",\"\",Message.NORMAL_TYPE,_tokens,null,null);");
        sb.append("\n").append(identation).append("// end joinblock\n");
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent, Map<String, SymbolType> typeEnv, Map<String, SymbolType> knownTypes) {
//        super.analyze(parent, typeEnv, knownTypes);
        block.analyze(this, typeEnv, knownTypes);
        return true;
    }

}
