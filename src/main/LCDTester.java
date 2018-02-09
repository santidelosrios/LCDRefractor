package main; 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//Complejidad del algoritmo antes de refractoring: O(n4)
//Complejidad del algoritmo después de refractoring: O(n3)
public class LCDTester {

    static final String CADENA_FINAL = "0,0";
    //El espacio entre cada impresión debe ser 1
    static final int ESPACIADO = 1; 
    //static final int LIMITE_INFERIOR = 0; 
    //static final int LIMITE_SUPERIOR = 5; 
    
    public static void main(String[] args) {        
        try {
            // Establece los segmentos de cada numero (Se incluye parametrización en el constructor del ArrayList
            List<String> listaComando = new ArrayList<String>();
            String comando = "";
            int espacioDig = 0;
        		//Este constructor de la clase Scanner no lanza ninguna excepción, por lo que no es necesario encerrar esta declaración en un try
        		Scanner lector = new Scanner(System.in); 
        		//No se incluye porque los requerimientos dicen que el espaciado debe ser de 1, sin embargo se deja el método en la clase Utils en caso de que el requerimiento cambie
        		//espacioDig = Utils.configurarDigitos(lector, comando, LIMITE_INFERIOR, LIMITE_SUPERIOR); 
        		
            do {
                System.out.print("Entrada: ");
                comando = lector.next();
                
                if(!comando.equalsIgnoreCase(CADENA_FINAL)) {
                    listaComando.add(comando);
                }
            } while (!comando.equalsIgnoreCase(CADENA_FINAL)); 
            //Cierro el lector porque no necesito leer más user inputs
            lector.close(); 

            ImpresorLCD impresorLCD = new ImpresorLCD();

            Iterator<String> iterator = listaComando.iterator();
             
            while (iterator.hasNext()) {
                try {
                		espacioDig = espacioDig == 0 ? ESPACIADO : espacioDig; 
                    impresorLCD.procesar(iterator.next(), espacioDig);
                    impresorLCD.imprimir();
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
