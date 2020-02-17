package enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;


public class Address {
    private PublicKey PK;
    private PrivateKey SK;
    private Double balance = 0.0;
    private final String symbol = "EZI";
    private GenSig sig;
         
    
    public Address() {
 
    }
    
    public void generateKeyPair() {
        KeyPair keys = GenSig.generateKeyPair();  
        PK = keys.getPublic();
        SK = keys.getPrivate();
        
    }
    
    @Override
    public String toString(){
        StringBuilder description = new StringBuilder();
        description.append("PK = ").append(PK.hashCode()).append('\n');
        description.append("Balacne = ").append(getBalance()).append(" ").append(symbol);
        return description.toString();
    }
    
    public void addEZI(Double EZI) {
        this.balance += EZI;
    }
    
    public Double getBalance() {
        return this.balance;
    }
    
    public void transferEZI(Double EZI) {
        addEZI(EZI);
    }
    
    public void send(TokenContract contract, Double enziniums) {
        if (enziniums <= getBalance()) {
            contract.payable(getPK(), enziniums);
            this.balance -= enziniums;
        }
    }
    
    public PublicKey getPK() {
        return PK;
    }
}
