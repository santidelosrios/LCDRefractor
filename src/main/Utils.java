package main;

import java.util.Scanner;

//Clase que tiene los métodos de utilidad generales
public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
    /**
    *
    * Metodo encargado de validar si una cadena es numerica
    *
    * @param cadena Cadena
    * @return boolean - si la cadena es numerica o no
    */  
   static boolean isNumeric(String cadena) {
       try {
           Integer.parseInt(cadena);
           return true;
       } catch (NumberFormatException ex) {
           return false;
       }
   }
   
   

   /**
   *
   * Metodo encargado de leer un input del usuario para el espacio entre los digitos (en caso de requerirse en un fúturo)
   *
   * @param Scanner lector
   * @param string comando anterior ingreso por el usuario
   * @param lowerLimit limite minimo para escoger el espaciado
   * @param upperLimit limite maximo para escoger el espaciado
   * @return boolean si la cadena es numerica o no
   * @throws IllegalArgumentException si el comando ingresado no es numerico o el digito no se encuentra entre los límites
   */  
   static int  configurarDigitos(Scanner lector, String comando, int lowerLimit, int upperLimit) throws IllegalArgumentException {
	   int espacioDig = 0; 
	   
       System.out.println("Espacio entre Digitos (0 a 5): ");
       comando = lector.next();

       // Valida si es un numero
       if (isNumeric(comando)) {
           espacioDig = Integer.parseInt(comando);
           
           // se valida que el espaciado este entre 0 y 5
           if(espacioDig < lowerLimit || espacioDig > upperLimit) {
        	   		lector.close();
        	   		throw new IllegalArgumentException("El espacio entre digitos debe estar entre" + lowerLimit + " y " + upperLimit + ": ");
           }
       } else {
    	   		lector.close();
    	   		throw new IllegalArgumentException("Cadena " + comando + " no es un entero");
       }
       
       return espacioDig; 
   }
	
	

}
