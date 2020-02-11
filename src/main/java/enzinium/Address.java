package enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;


public class Address {
    public PublicKey PK;
    private PrivateKey SK;
    protected Double balance = 0.0;
    public String symbol = "EZI";
    public GenSig sig;
         
    
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
        description.append("Balacne = ").append(balance).append(" ").append(symbol);
        return description.toString();
    }
    
    public void addEZI(Double EZI) {
        balance += EZI;
    }
    
    public void transferEZI(Double EZI) {
        
    }
    
    public void sendEZI(TokenContract contract, Double EZI) {
        
    }
    
    public int getPK() {
        return PK.hashCode();
    }
}
