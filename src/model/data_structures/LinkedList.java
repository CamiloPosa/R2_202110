package model.data_structures;

public class LinkedList <T extends Comparable<T>> implements ILinkedList<T>
{
	private Nodo<T> list;
	private int listSize;

	public LinkedList()
	{
		list = null;
	}

	public LinkedList (T item)
	{
		list = new Nodo<T>(item);
		listSize = 1;
	}

	public void addFirst (T item)
	{
		Nodo<T> newHead = new Nodo<> (item);
		newHead.setSigNodo(list);
		list = newHead;
		listSize ++;
	}

	public void addLast (T item)
	{
		Nodo<T> newHead = new Nodo<> (item);
		list.setSigNodo(newHead);
		listSize ++;
	}


	public void append(T item)
	{
		Nodo<T> newNode = new Nodo<> (item);

		if(list == null)
		{
			list = newNode;
		}

		else
		{
			Nodo<T> actual = list;
			while(actual.darSig() != null)
			{
				actual = actual.darSig();
			}
			actual.setSigNodo(newNode);
		}
		listSize++;
	}

	public void insertElement(T element, int pos)
	{
		Nodo<T> actual = list;
		int cont = 0;
		Nodo<T> nuevo = new Nodo<T>(element);
		boolean cent = false;
		while(actual.darSig() != null && cent == false)
		{
			Nodo<T> prev = actual;
			actual = actual.darSig();
			if(cont == pos)
			{
				prev.setSigNodo(nuevo);
				nuevo.setSigNodo(actual);
				cent = true;
			}
			cont ++;
		}
	}
	
	public T removeFirst()
	{
		T elem = null;
		Nodo<T> actual = list;
		elem = actual.darItem();
		Nodo<T> prev = actual;
		prev.setSigNodo(actual.darSig());
		return elem;
	}
	
	public T removeLast()
	{
		Nodo<T> actual = list;
		while(actual.darSig() != null)
		{
			actual = actual.darSig();
		}
		actual.setItem(null);
		return actual.darItem();
	}
	
	public T deleteElement(int pos)
	{
		T item = null;
		Nodo<T> actual = list;
		int cont = 0;
		boolean cent = false;
		if(actual.darSig() == null)
		{
			item = actual.darItem();
		}
		
		while(actual.darSig() != null && cent == false)
		{
			Nodo<T> prev = actual;
			actual = actual.darSig();
			if(cont == pos)
			{
				item = actual.darItem();
				prev.setSigNodo(actual.darSig());
				cent = true;
			}
		}
		return item;
	}
	
	public T firstElement()
	{
		Nodo<T> actual = list;
		return actual.darItem();
	}
	
	public T lastElement()
	{
		Nodo<T> actual = list;
		while(actual.darSig() != null)
		{
			actual = actual.darSig();
		}
		return actual.darItem();
	}
	
	public T getElement(int pos)
	{
		Nodo<T> actual = list;
		boolean cent = false;
		int cont = 0;
		while(actual!= null && cent == false )
		{
			
			if(cont == pos)
			{
				cent = true;
			}
			cont ++;
			actual = actual.darSig();
		}
		
		return actual.darItem();
	}
	
	public int size()
	{
		return listSize;
	}

	public boolean isEmpty()
	{
		boolean empt = false;
		if( listSize > 0)
		{
			empt = true;
		}
		return empt;
	}

	public int isPresent(T element)
	{
		int pos = -1;
		Nodo<T> actual = list;
		boolean cent = false;
		while(actual.darSig() != null && cent == false )
		{
			actual = actual.darSig();
			if(actual.equals(element))
			{
				cent = true;
			}
			pos+=2;
		}
		return pos;
	}
	
	public void exchange(int pos1, int pos2)
	{
		Nodo<T> actual1 = list;
		Nodo<T> actual2 = list;
		int cont1 = 0;
		int cont2 = 0;
		boolean cent = false;
		while(actual1.darSig() != null)
		{
			actual1 = actual1.darSig();
			if(cont1 == pos1)
			{
				while(actual2.darSig() != null && cent == false)
				{
					actual2 = actual2.darSig();
					if(cont2 == pos2)
					{
						actual2.setItem(actual1.darItem());
						cent = true;
					}
				}
				actual1.setItem(actual2.darItem());
			}
		cont1++;
		}
	}
	
	public void changeInfo(int pos, T elem)
	{
		Nodo<T> actual = list;
		boolean cent = false;
		int cont = 0;
		while(actual.darSig() != null && cent == false )
		{
			actual = actual.darSig();
			if(cont == pos)
			{
				actual.setItem(elem);
				cent = true;
			}
		}
	}
	public int compareTo(T elem1, T elem2)
	{
		int comp = -1;
		if(elem1.equals(elem1) == true)
		{
			comp = 0;
		}
		return comp;
	}
	
	

	
	
}

