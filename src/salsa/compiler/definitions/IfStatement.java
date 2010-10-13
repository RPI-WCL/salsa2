package salsa.compiler.definitions;

import salsa.compiler.SalsaNode;

public class IfStatement extends Statement implements SalsaNode {

    Expression e;

    Block block;

    Statement elseStatement;

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();

        sb.append(identation).append("if(").append(e.toJavaCode(identation))
                .append(")");

        sb.append(block.toJavaCode(identation));

        if (elseStatement != null) {
            sb.append("\n" + identation + "else").append(
                    elseStatement.toJavaCode(identation));
        }

        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        e.analyze(this);
        block.analyze(this);
        if (elseStatement != null)
            elseStatement.analyze(this);
        if (!e.getType().equalsIgnoreCase("boolean")) {
            this.log(e.getSalsaSource() + " needs to be a boolean type");
        }
        return true;
    }

    public void setExpression(Expression e) {
        this.e = e;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public void setElseStatement(Statement s) {
        this.elseStatement = s;
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
