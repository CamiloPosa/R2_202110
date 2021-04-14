package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico<Integer> arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() {
		arreglo = new ArregloDinamico<Integer>(TAMANO);
	}
	
	

	

	@Test
	public void testArregloDinamico() {
		// TODO
		assertTrue(arreglo != null);
		assertEquals(0, arreglo.size());
		assertEquals(TAMANO, arreglo.darCapacidad());
	}
	@Test
	public void size() {
		arreglo.append(23);
		assertTrue(arreglo.size() == 1 ); 
	    arreglo.append(0); 
	    assertTrue(arreglo.size() == 2 ); 
	}

	@Test
	public void agregar() {
		arreglo.append(23);
		assertTrue(arreglo.size() == 1 ); 
		assertTrue(arreglo.firstElement() == 23); 
	}
	
	@Test
	public void addFirst() {
		arreglo.append(23);
		arreglo.addFirst(8);
		assertTrue(arreglo.size() == 2 ); 
		assertTrue(arreglo.firstElement() == 8); 
	}
	
	
	@Test
	public void addLast() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.addLast(9);
		
		assertTrue(arreglo.size() == 3 ); 
		assertTrue(arreglo.lastElement() == 9); 
	}
	
	@Test
	public void removeFirst() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		
		assertTrue(arreglo.removeFirst() == 23);
		assertTrue(arreglo.firstElement() != 23);  
		
		 
	}
	
	
	@Test
	public void removeLast() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		
		assertTrue(arreglo.removeLast() == 9);
		assertTrue(arreglo.lastElement() != 9);  
		
		 
	}
	
	@Test
	public void darCapascidad() {
		assertTrue(arreglo.darCapacidad() == TAMANO); 
	}
	
	@Test
	public void firstElemento() {
		arreglo.append(23);
		arreglo.append(0);
		
		
		assertTrue(arreglo.firstElement() == 23);	 
	}
	@Test
	public void lastElemento() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(80);
		
		
		assertTrue(arreglo.lastElement() == 80);	
		
		
	}
	
	public void isEmpty() {
		
		assertTrue(arreglo.isEmpty() == true); 
		arreglo.append(23);
		arreglo.append(0);
		
		
		assertTrue(arreglo.isEmpty() == false);	 
	}
	
	public void getElemento() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(7);
		
		
		assertTrue(arreglo.getElement(2) == 7);
		assertTrue(arreglo.getElement(0) == 23);
	}
	
	public void compare() {
		arreglo.append(23);
		arreglo.append(0);	
		
		assertTrue(arreglo.compareTo(0, 0) == 0);
		assertTrue(arreglo.compareTo(1, 0) != 0);
		
	}

	
	@Test
	public void deleteElement() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		
		assertTrue(arreglo.deleteElement(0) == 23);
		assertTrue(arreglo.firstElement() != 23);  
	 
	}
	
	
	@Test
	public void insertElement() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		arreglo.insertElement(7, 1);
		assertTrue(arreglo.getElement(1) == 7);  
		assertTrue(arreglo.getElement(2) == 0); 		 
	}
	
	
	@Test
	public void changeInfo() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		arreglo.changeInfo(1, 7);
		assertTrue(arreglo.getElement(1) == 7);  		
		 
	}
		
	@Test
	public void isPresent() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		
		
		assertTrue(arreglo.isPresent(23) == 0);  
		assertTrue(arreglo.isPresent(99) == -1); 
	 
	}
	@Test
	public void exchanges() {
		arreglo.append(23);
		arreglo.append(0);
		arreglo.append(9);
		arreglo.exchange(0, 2);
		
		assertTrue(arreglo.getElement(0) == 9);  
		assertTrue(arreglo.getElement(2) == 23); 
	 
	}
	
	
}