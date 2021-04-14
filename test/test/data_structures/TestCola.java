package test.data_structures;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Cola;

public class TestCola 
{
	private Cola cola ;
	

	@Before
	public void setUp1() {
		cola = new Cola();
	}

	public void setUp2() 
	{
		
		for (int i = 0; i < 100; i++) 
		{
			cola.enqueue(i);
			
		}
			
		
	}

	@Test
	public void testEnqueue() 
	{
		setUp1();
		
		Integer entero = 2;
		cola.enqueue(entero);
		assertEquals(cola.darCola(), entero);
		assertEquals(cola.darCola() != null, cola.darCola());
		
		
	}
	
	@Test
	public void testDequeue()
	{
		setUp2();
		
		cola.dequeue();
		
		assertEquals(99, cola.darTamano());
	}
	
	
	@Test
	public void testSize()
	{
		setUp2();
		
		assertEquals(100, cola.darTamano());
	}

	

}
