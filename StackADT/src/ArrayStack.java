import java.util.Arrays;

public class ArrayStack<T> implements StackInterface<T> {
	public T[] stack;
	private int topIndex;
	private static final int DEFAULT_INITIAL_CAPACITY = 50;
	public ArrayStack() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	public ArrayStack(int initialCapacity) {
		T[] stack = (T[]) new Object[initialCapacity ];
		topIndex = -1;
	}
	public void push(T newEntry) {
		ensureCapacity();
		topIndex++;
		stack[topIndex] = newEntry;
	}
	private void ensureCapacity() {
		if(topIndex == stack.length -1)
			stack = Arrays.copyOf(stack, 2*stack.length);
	}
	public T peek() {
		T top = null;
		if(!isEmpty())
			top = stack[topIndex];
		return top;
	}
		
	public boolean isEmpty() {
		return topIndex == -1;
	}
	
	public T pop() {
		T top = null;
		if(!isEmpty()) {
			top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
		}
		
		return top;
	}
	public void clear() {
		for(int i = 0; i<topIndex;i++) {
			stack[i] = null;
		topIndex = -1;
		}
	}

}
