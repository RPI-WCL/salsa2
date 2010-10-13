package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;

public class JoinBlockStatement extends Statement implements SalsaNode {
    
    Block block;

    public JoinBlockStatement(Block block) {
        this.block = block;
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
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        block.analyze(this);
        return true;
    }

//    private int line = -1;
//    @Override
//    public void setLine(int line) {
//        this.line = line;
//    }
//    @Override
//    public int getLine() {
//        return line;
//    }
//    
//    private String salsaSource = "";
//    
//    @Override
//    public void setSalsaSource(String src) {
//        salsaSource = src;
//    }
//
//    @Override
//    public String getSalsaSource() {
//        return salsaSource;
//    }
    
}
