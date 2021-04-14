package model.data_structures;

public class TablaHashLinearProbing <K extends Comparable<K>, V> implements TablaSimbolos <K, V>
{
	private static final int CAPACITY = 4;
	private int n;          
	private int m;         
	private K[] keys;      
	private V[] values;


	public TablaHashLinearProbing()
	{
		this(CAPACITY);
	}

	public TablaHashLinearProbing(int capacidad) 
	{
		m = capacidad;
		n = 0;
		keys = (K[])   new Object[m];
		values = (V[]) new Object[m];
	}

	public int size() 
	{
		return n;
	}


	public boolean isEmpty() 
	{
		return size() == 0;
	}

	public boolean contains(K key) 
	{
		if (key == null) 
		{
			throw new IllegalArgumentException("El argumento que contiene es null");
		}
		return get(key) != null;
	}

	private int hash(K key) 
	{
		return (key.hashCode() & 0x7fffffff) % m;
	}

	private void resize(int capacidad) 
	{
		TablaHashLinearProbing<K, V> temp = new TablaHashLinearProbing<K, V>(capacidad);
		for (int i = 0; i < m; i++) {
			if (keys[i] != null) {
				temp.put(keys[i], values[i]);
			}
		}
		keys = temp.keys;
		values = temp.values;
		m= temp.m;
	}

	public void put(K key, V value) 
	{
		if (key == null)
		{
			throw new IllegalArgumentException("Primer elemento en poner es null");
		}

		if (value == null) 
		{
			remove(key);
			return;
		}

		if (n >= m/2)
		{
			resize(2*m);
		}

		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % m) 
		{
			if (keys[i].equals(key)) 
			{
				values[i] = value;
				return;
			}
		}
		keys[i] = key;
		values[i] = value;
		n++;
	}

	public V get(K key) 
	{
		if (key == null)
		{	
			throw new IllegalArgumentException("argument to get() is null");
		}	
		for (int i = hash(key); keys[i] != null; i = (i + 1) % m)
		{	
			if (keys[i].equals(key))
			{	
				return values[i];
			}
		}	
		return null;
	}


	public V remove(K key) 
	{
		V rt = null;
		if (key == null) 
		{	
			throw new IllegalArgumentException("El argumento a eliminar es null");
		}
		int i = hash(key);
		while (!key.equals(keys[i])) 
		{
			i = (i + 1) % m;
		}
		rt= values[i];
		keys[i] = null;
		values[i] = null;
		i = (i + 1) % m;
		while (keys[i] != null) 
		{	
			K keyToRehash = keys[i];
			V valToRehash = values[i];
			keys[i] = null;
			values[i] = null;
			n--;
			put(keyToRehash, valToRehash);
			i = (i + 1) % m;
		}
		n--;
		if (n > 0 && n <= m/8)
		{
			resize(m/2);
		}
		
		return rt;
	}

	public Cola keySet() 
	{
		Cola<K> queue = new Cola<K>();
		for (int i = 0; i < m; i++)		
		{	
			if (keys[i] != null)
			{
				queue.enqueue(keys[i]);
			}
		}    
		return queue;
	}

	public Cola valueSet() 
	{
		Cola<V> queue = new Cola<V>();
		for (int i = 0; i < m; i++)		
		{	
			if (values[i] != null) queue.enqueue(values[i]);
		}    
		return queue;
	}





}
