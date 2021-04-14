package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements ILinkedList<T>
{
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico(int max)
	{
		elementos = (T[]) new Comparable[tamanoMax];
		tamanoMax = max;
		tamanoAct = 0;
	}
	public void append( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  
			// caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public void addFirst(T element)
	{
		tamanoAct ++;
		for(int i = 0; i < tamanoAct; i++)
		{

			for(int j = i; j < tamanoAct + 1; j++)
			{
				elementos[j+1] = elementos[j];
			}
		}
		elementos[0] = element ;
	}

	public void addLast(T element)
	{
		elementos[tamanoAct] = element;
		tamanoAct++;
	}

	public void insertElement( T element, int pos)
	{
		for(int i = 0; i < tamanoAct; i++)
		{
			if(i == pos)
			{
				tamanoAct++;
				for(int j = i; j < tamanoAct + 1; j++)
				{
					elementos[j+1]= elementos [j];
				}
				elementos[pos] = element;
			}
		}
	}

	public T removeFirst()
	{
		elementos[0] = null;
		for(int i = 0; i<tamanoAct; i++)
		{
			for(int j = i; j < tamanoAct - 1; j++)
			{
				elementos[j] = elementos[j+1];
			}

		}
		tamanoAct--;
		return removeFirst();

	}

	public T removeLast()
	{
		elementos[tamanoAct] = null;
		tamanoAct--;
		return removeLast();
	}


	public int darCapacidad() 
	{
		return tamanoMax;
	}

	public T deleteElement(int pos) 
	{

		T dat = null;
		for ( int i = 0; i < tamanoAct; i++)
		{
			T a = elementos[i];
			if(pos == i)
			{
				for( int j=i; j< tamanoAct - 1; j++)
				{
					elementos[j]= elementos[j+1];
				}
				elementos[tamanoAct - 1]= null;
				dat = a;
			}
		}
		return dat;
	}

	public T firstElement()
	{
		T primer = elementos[0];
		return primer;
	}

	public T lastElement()
	{
		T primer = elementos[tamanoAct];
		return primer;
	}

	public T getElement(int i) 
	{
		// TODO implementar
		T dat = null;
		for ( int j = 0; j <= i ; j++)
		{
			if ( j == i)
			{
				dat = elementos[i];
			}
		}
		return dat;
	}


	public int size() 
	{
		return tamanoAct;
	}

	public boolean isEmpty()
	{
		boolean empty = false;
		if(elementos == null)
		{
			empty = true;
		}
		return empty;
	}


	public int isPresent(T element)
	{
		int pos = -1;
		for( int i = 0; i < tamanoAct; i++)
		{
			T a = elementos[i];
			if(compareTo(element, a) == 0)
			{
				pos = i;
			}
		}
		return pos;

	}

	public void exchange(int pos1, int pos2) {
		T primer = elementos[pos1];
		T segundo = elementos[pos2];
		elementos[pos2] = primer;
		elementos[pos1] = segundo;

	}

	public void changeInfo(int pos1, T element) 
	{
		elementos[pos1] = element;

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
