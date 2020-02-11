package enzinium;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Hashtable;


public class TokenContract {
    
    private String name;
    private String symbol;
    private Double totalSupply;
    private final Address address;
    private Hashtable<PublicKey, Double> balance = new Hashtable<PublicKey, Double>();

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
        double totalSupplyDouble = totalSupplyInput;
        totalSupply = totalSupplyDouble;
    }
    
    public String name() {
        return name;
    }
    
    public String symbol() {
        return symbol;
    }
    
    public Double totalSupply() {
        return totalSupply;
    }
    
    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();
        description.append("Name = ").append(name()).append('\n');
        description.append("Symbol = ").append(symbol()).append('\n');
        description.append("TotalSupply = ").append(totalSupply()).append('\n');
        description.append("Owner PK = ").append(address.getPK().hashCode()).append('\n');
        return description.toString();
    }
    
    public void addOwner(PublicKey PK, Double units) {
        balance
    }
}
