package enzinium;


public class TokenContract {
    
    private String name;
    private String symbol;
    private float totalSupply;
    private final Address address;
    private balance

    public TokenContract(Address rick) {
        this.address = rick;
    }

    
    public void setName(String nameInput) {
        name = nameInput;
    }
        
    public void setSymbol(String symbolInput) {
        symbol = symbolInput;
    }
    
    public void setTotalSupply(float totalSupplyInput) {
        totalSupply = totalSupplyInput;
    }
    
    public String name() {
        return name;
    }
    
    public String symbol() {
        return symbol;
    }
    
    public float totalSupply() {
        return totalSupply;
    }
    
    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();
        description.append("Name = ").append(name()).append('\n');
        description.append("Symbol = ").append(symbol()).append('\n');
        description.append("TotalSupply = ").append(totalSupply()).append('\n');
        description.append("Owner PK = ").append(address.getPK()).append('\n');
        return description.toString();
    }
}
