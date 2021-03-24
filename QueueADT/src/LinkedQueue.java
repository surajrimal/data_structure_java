
public class LinkedQueue<T> implements QueueInterface<T> {
	
	private Node firstNode;
	private Node lastNode;

	public LinkedQueue() {
		firstNode = null;
		lastNode = null;
		
	}
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

	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry, null);
		if(isEmpty()) {
			firstNode = newNode;
		}else {
			lastNode.setNextNode(newNode);
		}
		lastNode = newNode;

	}

	@Override
	public T dequeue() {
		T front = null;
		if(!isEmpty()) {
			front = (T) firstNode.getNodeData();
			firstNode = firstNode.getNextNode();
			if(firstNode == null) {
				lastNode = null;
			}
		}
		return front;
	}

	@Override
	public T getFront() {
		T front = null;
		if(!isEmpty()) {
			front = (T) firstNode.getNodeData();
		}
		return front;
	}

	
	public boolean isEmpty() {
		return (firstNode== null) && (lastNode == null);
	}

	@Override
	public void clear() {
		firstNode = null;
		lastNode = null;
	}

}
