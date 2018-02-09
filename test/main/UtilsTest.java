package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void testIsNumeric() {
		String test1 = "1"; 
		boolean real1 = Utils.isNumeric(test1);
		boolean esperado1 = true; 
		
		assertEquals(esperado1, real1);
		
		
		String test2 = "a"; 
		boolean real2 = Utils.isNumeric(test2);
		boolean esperado2 = false; 
		
		assertEquals(esperado2, real2);
		
		
		String test3 = "@"; 
		boolean real3 = Utils.isNumeric(test3);
		boolean esperado3 = false; 
		
		assertEquals(esperado3, real3);
	}

}
