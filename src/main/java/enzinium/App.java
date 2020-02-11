package enzinium;

/**
 * Contratos inteligentes con enZinium.
 * 
 * Rick va a organizar un concieto de Los Ricknillos
 * y quiere poner a la venta 100 entradas en nuestra
 * plataforma enZinium.
 * Para ello va a utilizar un contrato inteligente 
 * construido sobre nuestra plataforma.
 * Este contrato recibira instrucciones sobre a quien vender
 * las entradas. El contrato almacenara que usuarios/as 
 * de la plataforma poseen las entradas.
 * Cada usuario/a dipone de una Address /direccion en la
 * plataforma, desde la que gestionar sus enZiniums 
 * y las entradas.
 */

public class App {
     
    public static void main( String[] args )
    {
        /**
         * Crea una Address en nuestro sistema para Rick
         * Genera las claves privada y publica de la direccion
         * El balance de enZinium de su direccion es cero
         * El simbolo del enZinium es EZI
         */

        Address rick = new Address();
        rick.generateKeyPair();

        /**
         * Visualiza la direccion publica de Rick y su balance
         * 
         * Utiliza el metodo hashCode() de PublicKey para 
         * mostrar la PublicKey en consola 
         */
        
        System.out.println("\n" + "Address de Rick" + "\n" + 
                                  "==============="        );
        System.out.println(rick.toString());

        /**
         * Creamos una Address en nuestro sistema para Morty
         * y otra para Jen y visualizamos su direccion puvlica
         * y balance
         */
        
        Address morty = new Address();
        morty.generateKeyPair();

        Address jen = new Address();
        jen.generateKeyPair();

        System.out.println("\n" + "Address de Morty" + "\n" + 
                                  "==============="        );
        System.out.println(morty.toString());  
        System.out.println("\n" + "Address de Jen" + "\n" + 
                                  "==============="        );
        System.out.println(jen.toString());         

        /**
         * Crea una contrato inteligente de tipo TokenContract 
         * en nuestro sistema para que Rick pueda vender 100 
         * entradas para el concierto de "los Ricknillos". 
         *  
         * El nombre del token (las entradas) es Ricknillos.
         * Su simbolo es RNiLL.
         * 
         * El propietario del contrato es Rick. Asigna su Public Key
         * a la propiedad owner del contrato mediante el contructor
         * de TokenContract.
         * 
         * En la clase TokenContract programa las funciones a utilizar en 
         * el metodo toString():
         * 
         * name() 
         * @return devuelve el nombre del token de forma human-readable (p.e., “US Dollars�?).
         * 
         * symbol()
         * @return el nombre del símbolo del token de forma human-readable (p.e., “USD�?).
         * 
         * totalSupply()
         * @return el total de unidades de este token que actualmente existen.
         */

        TokenContract ricknillos = new TokenContract(rick);
        ricknillos.setName("Ricknillos");
        ricknillos.setSymbol("RNiLL");
        ricknillos.setTotalSupply(100);

        System.out.println("\n" + "Contrato de los Ricknillos" + "\n" + 
                                  "=========================="        );
        System.out.println(ricknillos.toString());

        /**
         * El contrato TokenContract contiene una tabla de balances 
         * de token por propietario:
         * mapping(propietario => numero de unidades que posee)
         * Permite al contrato llevar el seguimiento de quien
         * posee las entradas. 
         * Cada transferencia de entradas entre propietarios es 
         * una deducción en un balance y una adicion en el otro.
         * 
         * Crea una tabla "balances" que mapee cada propietario 
         * (su Public Key) al numero de tokens que posee.
         * Añade a Rick con sus 100 entradas.
         * Asegurate de que si el propietario (su Public Key) 
         * ya existe en la tabla, sus unidades no se actualicen.
         * 
         * addOwner()
         * añade el propietario inicial de todos los tokens de este contrato
         * @param PublicKey del propietario
         * @param cantidad de tokens que posee
         */

        ricknillos.addOwner(rick.getPK(), ricknillos.totalSupply());
        // verifica que Rick no se actualiza una vez que ya existe en el balance
        ricknillos.addOwner(rick.getPK(), 500d);
        
        /**
         * Consulta los balances
         * 
         * numOwners()
         * @return numero de propietarios registrados en la tabla balances
         * 
         * balanceOf()
         * @param PublicKey del propietario
         * @return cantidad de tokens que posee
         * Dada una direccion, devuelve su balance de tokens. Si no existe 
         * el propietario, devuelve cero.
         */
        System.out.println("\n" + "Consulta de balances" + "\n" + 
                                  "===================="        );

        System.out.println("\n" + "Numero de propietarios: " + ricknillos.numOwners());

        System.out.println("Entradas de Rick: " 
                                + ricknillos.balanceOf(rick.getPK()) 
                                + " "
                                + ricknillos.symbol());

        System.out.println("Entradas de Morty: " 
                                + ricknillos.balanceOf(morty.getPK())
                                + " "
                                + ricknillos.symbol());

        /**
         * Morty quiere comprarle 2 entradas a Rick
         * 
         * transfer()
         * @param PublicKey del destinatario
         * @param cantidad de tokens
         * Dada una direccion y una cantidad, transfiere esa cantidad
         * de tokens a esa direccion, desde el balance de la direccion
         * propietaria del contrato (la de Rick en este caso).
         * 
         * LLama a la funcion require() para comprobar si el propietario 
         * del contrato dispone de suficientes tokens. Si no hay suficientes,
         * falla silenciosamente (no hace nada) y no modifica los balances.
         * 
         * require()
         * @param una condicion que ha de verificarse (ser cierta)
         * Lanza una EXCEPCION si no se cumple la condicion
         */

            }
}
