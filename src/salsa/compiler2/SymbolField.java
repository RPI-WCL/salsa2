package salsa.compiler2;

public class SymbolField {
    private String name;
    private String typeName;
    private SymbolType symbolType;
    
    public SymbolField(String name, String typeName) {
        super();
        this.name = name;
        this.typeName = typeName;
    }
    
    
    
    public String getName() {
        return name;
    }



    public String getTypeName() {
        return typeName;
    }



    public SymbolType getSymbolType() {
        if (symbolType == null)
            this.formalizeTypes();
        return symbolType;
    }



    public void setSymbolType(SymbolType symbolType) {
        this.symbolType = symbolType;
    }


    public void formalizeTypes() {
        symbolType = CompilerHelper.getSymbolTypeByName(typeName);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return typeName + " " + name;
    }
}
