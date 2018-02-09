package main;
import main.Utils;


public class ImpresorLCD {
	//Constantes
    static final String CARACTER_VERTICAL = "|";
    static final String CARACTER_HORIZONTAL = "-";
    static final String POSICION_X = "X";
    static final String POSICION_Y = "Y"; 
    static final int SIZE_LIMITE_INFERIOR = 1; 
    static final int SIZE_LIMITE_SUPERIOR = 10; 
    static final int SUMA_COLUMNA = 2; 
    static final int MULTIPLICA_FILA = 2; 
    static final int ROW_ADDER = 3;

    // Puntos fijos
    private final int[] pf1;
    private final int[] pf2;
    private final int[] pf3;
    private final int[] pf4;
    private final int[] pf5;
    //Tamaño de cada fila y columna
    private int filasDig;
    private int columDig;
    //Cantidad de filas y columnas
    private int totalFilas;
    private int totalColum;
    //Tamaño por digito
    private int size;
    //Matriz
    private String[][] matrizImpr;

    public ImpresorLCD() {
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }
    
    /**
     * Método que inicializa los atributos de la clase que dependen de los parametros ingresados por el usuario
     * @param parametros
     */
    private void init(String[] parametros) {
        // Calcula el numero de filas cada digito
        this.filasDig = (MULTIPLICA_FILA * this.size) + ROW_ADDER;
        // Calcula el numero de columna de cada digito
        this.columDig = this.size + SUMA_COLUMNA;
        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDig;
        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columDig * parametros[1].length()) + (this.size * parametros[1].length());
        // crea matriz para almacenar los numeros a imprimir
        this.matrizImpr = new String[this.totalFilas][this.totalColum];
        
        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }
    }

    /**
     *
     * Metodo encargado de añadir una linea a la matriz de Impresion
     *
     * @param posicion Posición para ubicar la línea
     * @param punto punto fijo del segmento
     * @param orientacion 
     */    
    private void adicionarLinea(int posicion, int[] punto, String orientacion) {
    		int valor = 0;
    		
    		if(orientacion.equalsIgnoreCase(POSICION_X)) {
    			valor = punto[1] + posicion; 
    			this.matrizImpr[punto[0]][valor] = CARACTER_HORIZONTAL; 
    		} else {
    			valor = punto[0] + posicion;
    			this.matrizImpr[valor][punto[1]] = CARACTER_VERTICAL; 
    		}
    }

    /**
     *
     * Metodo encargado agregar los segmentos de un número a la matriz de Impresion
     *
     * @param segmento segmento a adicionar
     */  
    private void adicionarSegmento(int segmento) {
    		for(int i = 1; i<= this.size; i++) {
    			switch (segmento) {
	        		//Segmento superior vertical izquierdo
	            case 1:
	            		adicionarLinea(i, this.pf1, POSICION_Y);
	                break;
	            //Segmento superior vertical derecho
	            case 2:
	            		adicionarLinea(i, this.pf2, POSICION_Y);
	                break;
	            //Segmento inferior vertical izquierdo 
	            case 3:
	            		adicionarLinea(i, this.pf5, POSICION_Y);
	                break;
	            //Segmento inferior vertical derecho
	            case 4:
	            		adicionarLinea(i, this.pf4, POSICION_Y);
	                break;
	            //Segmento superior horizontal
	            case 5:
	            		adicionarLinea(i, this.pf1, POSICION_X);
	                break;
                //Segmento medio horizontal
	            case 6:
	            		adicionarLinea(i, this.pf2, POSICION_X);
	                break;
	            //Segmento inferior horizontal
	            case 7:
	            		adicionarLinea(i, this.pf3, POSICION_X);
	                break; 
	            default:
	            		break;
    			}
    		}
    }

    /**
     *
     * Metodo encargado de definir los segmentos que componen un digito y
     * a partir de los segmentos adicionar la representacion del digito a la matriz
     *
     * @param numero Digito
     */
    private void adicionarDigito(int numero) {
        switch (numero) {
        	//Para evitar recorrer una lista de segmentos, agrego cada segmento en los case y la complejidad total del algoritmo pasa de ser O(n4) a O(n3)
            case 1:
            		adicionarSegmento(3);
            		adicionarSegmento(4);
                break;
            case 2:
            		adicionarSegmento(5);
            		adicionarSegmento(3);
            		adicionarSegmento(6);
            		adicionarSegmento(2);
            		adicionarSegmento(7);
                break;
            case 3:
            		adicionarSegmento(5);
            		adicionarSegmento(3);
            		adicionarSegmento(6);
            		adicionarSegmento(4);
            		adicionarSegmento(7);
                break;
            case 4:
            		adicionarSegmento(1);
            		adicionarSegmento(6);
            		adicionarSegmento(3);
            		adicionarSegmento(4);
                break;
            case 5:
            		adicionarSegmento(5);
            		adicionarSegmento(1);
            		adicionarSegmento(6);
            		adicionarSegmento(4);
            		adicionarSegmento(7);
                break;
            case 6:
            		adicionarSegmento(5);
            		adicionarSegmento(1);
            		adicionarSegmento(6);
            		adicionarSegmento(2);
            		adicionarSegmento(7);
            		adicionarSegmento(4);
                break;
            case 7:
                adicionarSegmento(5);
                adicionarSegmento(3);
                adicionarSegmento(4);
                break;
            case 8:
                adicionarSegmento(1);
                adicionarSegmento(2);
                adicionarSegmento(3);
                adicionarSegmento(4);
                adicionarSegmento(5);
                adicionarSegmento(6);
                adicionarSegmento(7);
                break;
            case 9:
                adicionarSegmento(1);
                adicionarSegmento(3);
                adicionarSegmento(4);
                adicionarSegmento(5);
                adicionarSegmento(6);
                adicionarSegmento(7);
                break;
            case 0:
                adicionarSegmento(1);
                adicionarSegmento(2);
                adicionarSegmento(3);
                adicionarSegmento(4);
                adicionarSegmento(5);
                adicionarSegmento(7);
                break;
            default:
                break;
        }
    }

    /**
     *
     * Metodo encargado de configurar la matriz con base en los números dados
     *
     * @param numeroImp Numeros a Imprimir
     * @param espacio Espacio Entre digitos
     * @throws IllegalArgumentException 
     */    
    private void configurarMatriz(String numeroImp, int espacio) throws IllegalArgumentException{
        int pivotX = 0;
        char[] digitos = numeroImp.toCharArray();

        for (char digito : digitos) {
            
            //Valida que el caracter sea un digito
            if( ! Character.isDigit(digito)) {
                throw new IllegalArgumentException("Caracter " + digito + " no es un digito");
            }

            int numero = Integer.parseInt(String.valueOf(digito));

            //Calcula puntos fijos
            this.pf1[0] = 0;
            this.pf1[1] = 0 + pivotX;

            this.pf2[0] = (this.filasDig / 2);
            this.pf2[1] = 0 + pivotX;

            this.pf3[0] = (this.filasDig - 1);
            this.pf3[1] = 0 + pivotX;

            this.pf4[0] = (this.columDig - 1);
            this.pf4[1] = (this.filasDig / 2) + pivotX;

            this.pf5[0] = 0;
            this.pf5[1] = (this.columDig - 1) + pivotX;

            pivotX = pivotX + this.columDig + espacio;

            adicionarDigito(numero);
        }
    }
    /**
     * Metodo que se encarga de imprimir en consola la matriz con todos los números ingresados por el usuario
     */
    public void imprimir() {    		
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                System.out.print(this.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }

	 /**
	 *
	 * Metodo encargado de procesar la entrada que contiene el size del segmento
	 * de los digitos y los digitos a imprimir
	 *
	 * @param comando Entrada que contiene el size del segmento de los digito
	 * y el numero a imprimir
	 * @param espacioDig Espacio Entre digitos
	 * @throws IllegalArgumentException Si los datos ingresados por el usuario no corresponden al formato de entrada
	 */  
    public void procesar(String comando, int espacioDig) throws IllegalArgumentException {
    		if (!comando.contains(",")) {
	        throw new IllegalArgumentException("Cadena " + comando + " no contiene caracter ,");
	    }
	    
	    String [] parametros = comando.split(",");
	    
	    if(parametros.length != 2) {
	    		throw new IllegalArgumentException("Cadena" + comando + "Debe contener exactamente un carácter ',' que separe los parámetros de entrada. Ej: 2,12345 ");
	    }
	    //Valida que el parametro size sea un numerico
	    if(Utils.isNumeric(parametros[0])) {
	   		//Inicializa el tamaño de cada número impreso
	        this.size = Integer.parseInt(parametros[0]);	
	        
	        // se valida que el size este entre 1 y 10
	        if(this.size < SIZE_LIMITE_INFERIOR || this.size > SIZE_LIMITE_SUPERIOR) {
	            throw new IllegalArgumentException("El parametro size ["+ this.size + "] debe estar entre" + SIZE_LIMITE_INFERIOR + " y " + SIZE_LIMITE_SUPERIOR);
	        }
	        
	        //Se inicializan las variables de la clase
	    		init(parametros);
	        
		    // Realiza la configuración del numero en la matriz
		    configurarMatriz(parametros[1], espacioDig);
	    } else {
	        throw new IllegalArgumentException("Parametro Size [" + parametros[0] + "] no es un numero");
	    }
    }

    /*
     * GETERS
     */
	public int getFilasDig() {
		return filasDig;
	}

	public int getColumDig() {
		return columDig;
	}

	public int getTotalFilas() {
		return totalFilas;
	}

	public int getTotalColum() {
		return totalColum;
	}

	public int getSize() {
		return size;
	}

	public String[][] getMatrizImpr() {
		return matrizImpr;
	}
}