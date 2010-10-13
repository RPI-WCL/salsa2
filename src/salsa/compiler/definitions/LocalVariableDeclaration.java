package salsa.compiler.definitions;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import salsa.compiler.SalsaNode;

public class LocalVariableDeclaration extends Statement implements SalsaNode {

    public List<VariableDeclaration> variableDeclarations = new Vector<VariableDeclaration>();
    
    public void addVariableDeclaration(VariableDeclaration vd) {
        variableDeclarations.add(vd);
        if (vd.getInitExpresssion() != null)
            this.setSendMessage(vd.getInitExpresssion().isSendMessage());
    }

    @Override
    public String toJavaCode(String identation) {
        StringBuilder sb = new StringBuilder();
        
        for (Iterator<VariableDeclaration> it = variableDeclarations.iterator();
            it.hasNext();) {
            VariableDeclaration vd = it.next();
            sb.append(vd.toJavaCode(identation));
            if (this.isContinuation() && this.isSendMessage()) {
                sb.append("\n");
                sb.append(identation).append("token = ").append(vd.getName());
            }
            sb.append(";");
        }        
        return sb.toString();
    }

    @Override
    public boolean analyze(SalsaNode parent) {
        super.analyze(parent);
        for (Iterator<VariableDeclaration> it = variableDeclarations.iterator(); it
                .hasNext();) {
            VariableDeclaration vd = it.next();
            vd.analyze(this);
        }
        return true;
    }
    
//    PRIVATE INT LINE = -1;
//    @OVERRIDE
//    PUBLIC VOID SETLINE(INT LINE) {
//        THIS.LINE = LINE;
//    }
//    @OVERRIDE
//    PUBLIC INT GETLINE() {
//        RETURN LINE;
//    }
//    
//    PRIVATE STRING SALSASOURCE = "";
//    
//    @OVERRIDE
//    PUBLIC VOID SETSALSASOURCE(STRING SRC) {
//        SALSASOURCE = SRC;
//    }
//
//    @OVERRIDE
//    PUBLIC STRING GETSALSASOURCE() {
//        RETURN SALSASOURCE;
//    }
//    
}
