
public class LinkedListClass <T> implements LinkedListInterface<T> {
	private class Node<T>{
		private T nodeData;
		private Node<T> nextNode = null;
		
		public Node(T nodeData) {
			this.nodeData = nodeData;
			
		}
		public Node(T nodeData, Node<T> nextNode) {
			this.nodeData = nodeData;
			this.nextNode = nextNode;
		}
	
	
	public T getNodeData() {
		return nodeData;
	}
	
	public void setNodeData(T nodeData) {
		this.nodeData = nodeData;
	}
	
	public Node<T>getNextNode(){
		return nextNode;
	}
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	}
	
	private int numberOfElements = 0;
	private Node<T>  head;

	public boolean isEmpty() {
		if(numberOfElements == 0)
			return true;
		else
			return false;
		//O(1)
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfElements;
		//O(1)
	}

	public boolean contains(T input) {
		if(head == null) {
			return false;
		}
		
		Node<T> temp = head;
		while(temp!= null) {
			if(input.equals(temp.getNodeData())) {
				return true;
			}
			temp = temp.getNextNode();
		}
		return false;
		//O(n)
	}

	public int getCount(T input) {
		if(head == null) {
			return 0;
		}
		int count = 0;
		Node<T> temp = head;
		while(temp!= null) {
			if(input.equals(temp.getNodeData())) {
				count++;
			}
			temp = temp.getNextNode();
		}
		return count;
		//O(n)
	}

	public void addAtHead(T input) {
		Node<T> temp = head;
		Node<T> newNode = new Node<T>(input);
		head = newNode;
		head.setNextNode(temp);
		numberOfElements++;
		//O(1)
	}

	public void addAtTail(T input) {
		if(head == null) {
			head = new Node<T>(input);
		}
		else {
			Node<T> tail = head;
			while(tail.getNextNode()!= null) {
				tail = tail.getNextNode();
			}
			Node<T> newNode = new Node<T>(input);
			tail.setNextNode(newNode);
		}
		numberOfElements++;
		//O(1)
		
	}

	public boolean addAtIndex(T input, int index) {
		if(index> numberOfElements) {
			return false;
		}
		if(index == 0) {
			addAtHead(input);
			return true;
		}
		else if(numberOfElements == index) {
			addAtTail(input);
			return true;
		}
		else {
			Node<T> temp = head;
			for(int i = 0; i< (index-1); i++) {
				temp= temp.getNextNode();
			}
			/*while(temp.getNextNode()!= temp.nodeData) {
				temp = temp.getNextNode();
			}*/
			Node<T> tempNext = temp.getNextNode();
			Node<T> newNode = new Node<T>(input);
			temp.setNextNode(newNode);
			newNode.setNextNode(tempNext);
			numberOfElements--;
			
			return true;
			
		}
		//O(n)
		
	}

	public T getHead() {
		return head.getNodeData();
		//O(1)
	}

	public T getTail() {
		if(head == null) {
			return null;
		}
		else {
			Node<T> tail = head;
			while(tail.getNextNode()!= null) {
				tail = tail.getNextNode();
			}
			return tail.getNodeData();
		}
		//O(n)
	} 

	public T getAtIndex(int index) {
		if(head == null) {
			return null;
		}
		else {
			Node<T> temp = head;
			for(int i = 0; i< index; i++) {
				temp= temp.getNextNode();
			}
			return temp.getNodeData();
		}
		//O(n)
	}

	public T removeHead() {
		if(head == null) {
			return null;
		}
		Node<T> temp = head;
		head = head.getNextNode();
		numberOfElements--;
		return temp.getNodeData();
		//O(1)
	}

	public T removeTail() {
		return removeAtIndex(numberOfElements -1);
		//O(1)
	}

	public T removeAtIndex(int index) {
		if(head == null || (index>= numberOfElements)) {
			return null;
		}
		if(index ==0) {
			T temp = removeHead();
			return temp;
		}
		
			Node<T> temp = head;
			
			
			for(int i = 0; i< (index-1); i++) {
				temp= temp.getNextNode();
				
			}
			
			Node<T> tempNext = temp.getNextNode();
			temp.setNextNode(tempNext.getNextNode());
			numberOfElements--;
			return tempNext.getNodeData();
			//O(n)
	
	}

	@Override
	public void removeAll() {
		head = null;
		numberOfElements = 0;
		//O(1)
		
	}
	
	

}

