
public class ArrayQueue<T> implements QueueInterface<T> {
	private T[] queueData;
	private int frontIndex;
	private int backIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	

	public ArrayQueue() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	public ArrayQueue(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tempQueue = (T[]) new Object[initialCapacity + 1];
		queueData = tempQueue;
		frontIndex = 0;
		backIndex = initialCapacity;
			
		
	}

	public void enqueue(T newEntry) {
		ensureCapacity();
		backIndex = (backIndex+1)%queueData.length;
		queueData[backIndex] = newEntry;

	}
	private void ensureCapacity() {
		if(frontIndex == (backIndex+2)%queueData.length) {
			int count = queueData.length -1;
			T[] tempQueue = (T[]) new Object[queueData.length*2];
			for(int i =0; i<count; i++) {
				tempQueue[i] = queueData[frontIndex];
				frontIndex = (frontIndex+1)%queueData.length;
			}
			queueData = tempQueue;
			frontIndex = 0;
			backIndex = count -1;
			
		}
	}

	public T dequeue() {
		T front = null;
		if(!isEmpty()) {
			front = queueData[frontIndex];
			queueData[frontIndex]= null;
			frontIndex = (frontIndex +1 )%queueData.length;
			}
		return front;
	}

	public T getFront() {
		T front = null;
		if(!isEmpty()) {
			front = queueData[frontIndex];
			}
		return front;
	}

	@Override
	public boolean isEmpty() {
		return frontIndex == (backIndex+1)%queueData.length;
	}

	@Override
	public void clear() {
		while(!isEmpty()) {
			dequeue(); 
		}

	}
	public void expandQueue() {
		int count = queueData.length -1;
		T[] tempQueue = (T[]) new Object[queueData.length *2];
		for(int i =0; i<count; i++) {
			tempQueue[i] = queueData[frontIndex];
			frontIndex = (frontIndex+1)%queueData.length;
		}
		queueData = tempQueue;
		frontIndex = 0;
		backIndex = count -1;
	}

}
