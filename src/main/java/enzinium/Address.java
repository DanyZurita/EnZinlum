package enzinium;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;


public class Address {
    private PublicKey PK;
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
        StringBuilder addressDescription = new StringBuilder();
        addressDescription.append("PK =").append(PK.hashCode()).append('\n');
        addressDescription.append("Balacne = ").append(balance).append(symbol);
        return addressDescription.toString();
    }
    
    public void addEZI(Double EZI) {
        balance += EZI;
    }
    
    public void transferEZI(Double EZI) {
        
    }
}
