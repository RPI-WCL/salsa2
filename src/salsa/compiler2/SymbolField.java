package salsa.compiler2;

public class SymbolField {
    private String name;
    private String type;
    public SymbolField(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }
    
    
    
    public String getName() {
        return name;
    }



    public String getType() {
        return type;
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return type + " " + name;
    }
}
