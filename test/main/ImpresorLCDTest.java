package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImpresorLCDTest {
	static final int ESPACIADO = 1; 
	
	String[] comandos = {"2,12345", "0,67890", "e,12345"};

	@Test
	public void testProcesar() {
		String comando = comandos[0];
		ImpresorLCD impresor = new ImpresorLCD(); 
		
		impresor.procesar(comando, ESPACIADO);
		
		int size = impresor.getSize();
		int filasDig = impresor.getFilasDig(); 
		int columnDig =  impresor.getColumDig(); 
		int totalFilas = impresor.getFilasDig(); 
		int totalColumnas = impresor.getTotalColum(); 
		
		int esperadoSize = 2; 
		int esperadoFilasDig = 7; 
		int esperadoColumnDig = 4;
		int esperadoTotalFilas = 7; 
		int esperadoTotalColumnas = 30;

		assertEquals(esperadoSize, size);
		assertEquals(esperadoFilasDig, filasDig);
		assertEquals(esperadoColumnDig, columnDig);
		assertEquals(esperadoTotalFilas, totalFilas);
		assertEquals(esperadoTotalColumnas, totalColumnas);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testProcesarNotDigitException() {
		String comando = this.comandos[2]; 
		
		ImpresorLCD impresor = new ImpresorLCD(); 
		impresor.procesar(comando, ESPACIADO);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testProcesarOutOfLimitException() {
		String comando = this.comandos[1]; 
		
		ImpresorLCD impresor = new ImpresorLCD(); 
		impresor.procesar(comando, ESPACIADO);
	}

}
