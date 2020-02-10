package enzinium;

import org.junit.Test;


public class AddressTest {
    
    @Test
    public void createAddress(){
        Address morty = new Address();
        morty.generateKeyPair();
        System.out.println(morty.toString()); 
    }
}
