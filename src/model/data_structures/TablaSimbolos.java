package model.data_structures;

public interface TablaSimbolos<K extends Comparable<K>, V> 
{
	void put(K key, V value);
	
	V get(K key);
	
	V remove(K key);
	
	boolean contains(K key);
	
	boolean isEmpty();
	
	int size();	
	
	Cola<K> keySet();
	
	Cola<K> valueSet();
	
}
