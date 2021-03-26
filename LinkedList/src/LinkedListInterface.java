
public interface LinkedListInterface<T> {
	public boolean isEmpty();
	public int getCurrentSize();
	public boolean contains(T input);
	public int getCount(T input);
	
	public void addAtHead(T input);
	public void addAtTail(T input);
	public boolean addAtIndex(T input, int index);
	
	public T getHead();
	public T getTail();
	public T getAtIndex(int index);
	
	public T removeHead();
	public T removeTail();
	public T removeAtIndex(int index);
	public void removeAll();

}
