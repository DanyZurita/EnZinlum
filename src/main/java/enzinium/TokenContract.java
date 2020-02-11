package enzinium;


public class TokenContract {
    
    private String name;
    private String symbol;
    private int totalSupply;
    private final Address address;

    public TokenContract(Address rick) {
        this.address = rick;
    }

    
    public void setName(String nameInput) {
        name = nameInput;
    }
        
    public void setSymbol(String symbolInput) {
        symbol = symbolInput;
    }
    
    public void setTotalSupply(int totalSupplyInput) {
        totalSupply = totalSupplyInput;
    }
    
}
