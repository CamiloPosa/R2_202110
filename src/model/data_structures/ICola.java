package model.data_structures;

public interface ICola<T>
{

	public void enqueue(T item);

	public T dequeue();

	public int darTamano();
	
}