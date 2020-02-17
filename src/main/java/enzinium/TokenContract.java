package enzinium;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;


public class TokenContract {
    
    
    private String name;
    private String symbol;
    private Double totalSupply;
    private final Address owner;
    private final PublicKey ownerPK;
    private final Map<PublicKey, Double> balances = new HashMap<PublicKey, Double>();

    public TokenContract(Address owner) {
        this.owner = owner;
        this.ownerPK = owner.getPK();
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
        return this.name;
    }
    
    public String symbol() {
        return this.symbol;
    }
    
    public Double totalSupply() {
        return this.totalSupply;
    }
    
    public Address owner() {
        return this.owner;
    }
    
    public  Map<PublicKey, Double> balances() {
        return this.balances;
    }
    
    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();
        description.append("Name = ").append(name()).append('\n');
        description.append("Symbol = ").append(symbol()).append('\n');
        description.append("TotalSupply = ").append(totalSupply()).append('\n');
        description.append("Owner PK = ").append(this.ownerPK.hashCode()).append('\n');
        return description.toString();
    }
    
    public void addOwner(PublicKey PK, Double units) {
        balances().put(PK, units);
    }
    
    public int numOwners() {
        return balances().size();
    }
    
    public Double balanceOf(PublicKey PK) {
        if (balances().get(PK) == null){
            return 0.0;
        }
        return balances().get(PK);
    }
    
    public void transfer(PublicKey receptor, Double units){
        try {
            Boolean stockable = false;
            if (balanceOf(owner().getPK()) >= units) {
                stockable = true;
            }
            require(stockable);
            balances().compute(owner().getPK(), (pk, tokens) -> tokens - units);
            balances().put(receptor, balanceOf(receptor) + units);
        }
        catch (Exception e) {}
        
    }
    
    public void transfer(PublicKey sender, PublicKey receptor, Double units){
        try {
            Boolean stockable = false;
            if (balanceOf(sender) >= units) {
                stockable = true;
            }
            require(stockable);
            balances().put(sender, balanceOf(sender) - units);
            balances().put(receptor, balanceOf(receptor) + units);
        }
        catch (Exception e) {}
        
    }
    
    private void require(Boolean holds) throws Exception {
        if (! holds) {
            throw new Exception();
        }
    }
    
    public void owners() {
        for (PublicKey pk : balances().keySet()) {
            StringBuilder balanceString = new StringBuilder();
            balanceString.append("Owner: ").append(pk.hashCode()).append(" ");
            balanceString.append(balanceOf(pk)).append(" ");
            balanceString.append(symbol()).append('\n');
            System.out.print(balanceString);
        }
        
    }
}
