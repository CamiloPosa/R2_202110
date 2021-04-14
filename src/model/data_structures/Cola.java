package model.data_structures;

public class Cola<T> implements ICola<T>
{
	private Nodo<T> cola;
	private Nodo<T> cabeza;
	int tamano;
	
	public Cola()
	{
		cabeza = null;
		cola = null;
	}
	
	public Nodo<T> darCola()
	{
		return cola;
	}
	

	public void enqueue(T item) 
	{

		Nodo<T> nuevaCola = new Nodo<T>(item);
		
		if(cola == null){
			cola = nuevaCola;
			cabeza = nuevaCola;
		}
		else{
			cabeza.setAnterior(nuevaCola);
			cabeza = nuevaCola;
		}
		tamano++;
	}

	
	public T dequeue() 
	{
		
		T nodo = cola.darItem();
		cola = cola.getAnterior();
		tamano--;
		return nodo;

	}
	public Nodo darCabeza()
	{
		return cabeza;
	}
	public Nodo getElement(int pPosicion)
	{
		int i=0;
		boolean acabo= false;
		Nodo actual= cabeza;
		while(i<tamano&&!acabo)
		{
			if(i==pPosicion)
			{
				acabo= true;
			}
			actual= actual.getAnterior();
			i++;
		}
		return actual;
		
	}
	
	public int darTamano()
	{
		return tamano;
		
	}
}
