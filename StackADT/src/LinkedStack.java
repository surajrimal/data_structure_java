
public class LinkedStack<T> implements StackInterface<T> {
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
	private Node<T>  topNode = null;


	public void push(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry);
		topNode = newNode;

	}

	public T pop() {
		T top = peek();
		if(topNode != null) {
			topNode = topNode.getNextNode();

		}
		return top;
	}

	public T peek() {
		T top = null;
		if(topNode != null) {
			top = topNode.getNodeData();
		}
		return top;
	}

	@Override
	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public void clear() {
		topNode = null;

	}

}
