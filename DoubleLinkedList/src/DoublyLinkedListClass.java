
public class DoublyLinkedListClass <T> implements DoublyLinkedListInterface<T> {
	private class Node<T>{
		private T nodeData;
		private Node<T> nextNode = null;
		private Node<T> prevNode = null;
		
		public Node(T nodeData) {
			this.nodeData = nodeData;
			
		}
		public Node(T nodeData, Node<T> nextNode, Node<T> prevNode) {
			this.nodeData = nodeData;
			this.nextNode = nextNode;
			this.prevNode = prevNode;
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
	public Node<T> getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(Node<T> prevNode) {
		this.prevNode = prevNode;
	}
	
	}
	
	private int numberOfElements = 0;
	private Node<T>  head;
	private Node<T>  tail;

	public boolean isEmpty() {
		if(numberOfElements == 0)
			return true;
		else
			return false;
		//O(1)
	}

	public int getCurrentSize() {
		return numberOfElements;
		//O(1)
	}

	public boolean contains(T input) {
		if(head == null) {
			return false;
			//O(1)
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
		Node<T> newNode = new Node<T>(input);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.setNextNode(head);
			head.setPrevNode(newNode);
			head = newNode;
		}
		numberOfElements++;
		//O(1)
		
	}

	public void addAtTail(T input) {
		Node<T> newNode = new Node<T>(input);
		if(tail == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.setPrevNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
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
			Node<T> newNode = new Node<T>(input);
			Node<T> temp;
			if(index<(numberOfElements/2)) {
				temp = head;
				for(int i = 0; i< index; i++) {
					temp= temp.getNextNode();
				}
			}else {
				temp = tail;
				for(int i = numberOfElements -1; i< index; i--) {
					temp= temp.getPrevNode();
				}
			}
			newNode.setNextNode(temp);
			newNode.setPrevNode(temp.getPrevNode());
			
			temp.getPrevNode().setNextNode(newNode);
			temp.setPrevNode(newNode);
			numberOfElements++;
			
			return true;
			//O(n)
			
		}
		
	}

	public T getHead() {
		return head.getNodeData();
		//O(1)
	}

	public T getTail() {
		return tail.getNodeData();
		//O(1)
	} 

	public T getAtIndex(int index) {
		if(head == null) {
			return null;
		}
		Node<T> temp;
		if(index<(numberOfElements/2)) {
			temp = head;
			for(int i = 0; i< index; i++) {
				temp= temp.getNextNode();
			}
			
		}
	
		else {
			temp = tail;
			for(int i = numberOfElements -1; i>index ; i--) {
				temp= temp.getPrevNode();
			}
			
		}
		return temp.getNodeData();
		//O(n)
	}

	public T removeHead() {
		if(head == null) {
			return null;
		}
		Node<T> temp = head;
		if(numberOfElements == 1) {
			head = null;
			tail = null;
		}else {
			head = head.getNextNode();
			head.setPrevNode(null);
		}
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
		}else if(index ==(numberOfElements -1)) {
			T tempData = removeTail();
			return tempData;
		}else {
		
			Node<T> temp = head;
			if(index ==(numberOfElements/2)) {
				temp = head;
				for(int i = 0; i< index; i++) {
					temp= temp.getNextNode();
					
				}
				
			}else {
				temp = tail;
				for(int i = 0; i< index-1; i++) {
					temp= temp.getPrevNode();
				
				}
			}
			temp.getPrevNode().setNextNode(temp.getNextNode());	
			temp.getNextNode().setPrevNode(temp.getPrevNode());
		
			numberOfElements--;
			return temp.getNodeData();
			//O(n)
	
	}}

	@Override
	public void removeAll() {
		head = null;
		tail = null;
		numberOfElements = 0;
		//O(1)
		
	}
	public void printList() {
		Node<T> temp;
		System.out.println("Printing the list:");
		temp = head;
		while(temp != null) {
			System.out.println(temp.getNodeData());
			temp = temp.getNextNode();
		}
		System.out.println();
		System.out.println("Printing the list in reverse order:");
		temp = tail;
		while(temp != null) {
			System.out.println(temp.getNodeData());
			temp = temp.getPrevNode();
		}
		System.out.println();
		//O(n^2)
	}
	

}

