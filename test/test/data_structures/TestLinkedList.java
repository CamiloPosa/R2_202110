package test.data_structures;
import model.data_structures.LinkedList; 

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestLinkedList {

	private LinkedList<Integer> lista;
	
	
	@Before
	public void setUp1() {
		lista = new LinkedList<>(); 
	}
	
	

	

	@Test
	public void testLinkedList() {
		// TODO
		assertTrue(lista.size() == 1);
		assertTrue(lista != null); 
		
	}
	@Test
	public void agregar() {
		lista.append(23);
		assertTrue(lista.size() == 1 ); 
		assertTrue(lista.firstElement() == 23); 
	}

	public void compareTo() 
	{
		lista.append(23);
		lista.append(0);	
		
		assertTrue(lista.compareTo(lista.getElement(0), lista.getElement(1)) != 0);
		assertTrue(lista.compareTo(0,0) == 0);
		
	}
	
	@Test
	public void size() {
		
		assertTrue(lista.size() == 0 );
		lista.append(1);
		lista.append(2);
	    assertTrue(lista.size() == 2 ); 
	}

	
	
	@Test
	public void addFirst() {
		lista.append(0);
		lista.addFirst(8);
		assertTrue(lista.firstElement() == 8); 
	}
	
	
	@Test
	public void addLast() {
		lista.append(23);
		lista.append(0);
		lista.addLast(9);
		
		assertTrue(lista.size() == 3 ); 
		assertTrue(lista.lastElement() == 9); 
	}
	
	@Test
	public void removeFirst() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		
		assertTrue(lista.removeFirst() == 23);
		assertTrue(lista.firstElement() != 23);  
		
		 
	}
	
	
	@Test
	public void removeLast() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		
		assertTrue(lista.removeLast() == 9);
		assertTrue(lista.lastElement() != 9);  
		
		 
	}
	
	
	@Test
	public void firstElemento() {
		lista.append(23);
		lista.append(0);
		
		
		assertTrue(lista.firstElement() == 23);	 
	}
	@Test
	public void lastElemento() {
		lista.append(23);
		lista.append(0);
		lista.append(80);
		
		
		assertTrue(lista.lastElement() == 80);	
		
		
	}
	
	public void isEmpty() {
		
		assertTrue(lista.isEmpty() == true); 
		lista.append(23);
		lista.append(0);
	
		assertTrue(lista.isEmpty() == false);	 
	}
	
	public void getElemento() {
		lista.append(23);
		lista.append(0);
		lista.append(7);
		
		
		assertTrue(lista.getElement(2) == 7);
		assertTrue(lista.getElement(0) == 23);
	}
	
	

	
	@Test
	public void deleteElement() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		
		assertTrue(lista.deleteElement(0) == 23);
		assertTrue(lista.firstElement() != 23);  
	 
	}
	
	
	@Test
	public void insertElement() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		lista.insertElement(7, 1);
		assertTrue(lista.getElement(1) == 7);  
		assertTrue(lista.getElement(2) == 0); 		 
	}
	
	
	@Test
	public void changeInfo() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		lista.changeInfo(1, 7);
		assertTrue(lista.getElement(1) == 7);  		
		 
	}
		
	@Test
	public void isPresent() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		
		
		assertTrue(lista.isPresent(23) == 0);  
		assertTrue(lista.isPresent(99) == -1); 
	 
	}
	@Test
	public void exchanges() {
		lista.append(23);
		lista.append(0);
		lista.append(9);
		lista.exchange(0, 2);
		
		assertTrue(lista.getElement(0) == 9);  
		assertTrue(lista.getElement(2) == 23); 
	 
	}
	
	



}