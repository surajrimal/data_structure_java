
public class BinaryNode<T> implements BinaryNodeInterface<T> {
	private T data;
	private BinaryNode<T> left;
	private BinaryNode<T> right;
	

	public BinaryNode() {
		this(null);
	}
	public BinaryNode(T dataPortion) {
		this(dataPortion, null, null);
	}
	public BinaryNode(T dataPortion, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
		data = dataPortion;
		left = leftChild;
		right = rightChild;
	}


	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void setData(T newData) {
		// TODO Auto-generated method stub
		data = newData;

	}

	@Override
	public BinaryNodeInterface<T> getLeftChild() {
		// TODO Auto-generated method stub
		return left;
	}

	@Override
	public BinaryNodeInterface<T> getRightChild() {
		// TODO Auto-generated method stub
		return right;
	}

	@Override
	public void setLeftChild(BinaryNodeInterface<T> leftChild) {
		// TODO Auto-generated method stub
		left = (BinaryNode<T>)leftChild;

	}

	@Override
	public void setRightChild(BinaryNodeInterface<T> rightChild) {
		// TODO Auto-generated method stub
		right = (BinaryNode<T>)rightChild;

	}

	@Override
	public boolean hasLeftChild() {
		// TODO Auto-generated method stub
		return left!= null;
	}

	@Override
	public boolean hasRightChild() {
		// TODO Auto-generated method stub
		return right!= null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return (left == null) &&(right == null);
	}

	@Override
	public int getNumberOfNodes() {
		int leftNumber = 0;
		int rightNumber = 0;
		if(left!=null) {
			leftNumber = left.getNumberOfNodes();
		}
		if(right!= null) {
			rightNumber = right.getNumberOfNodes();
		}
		return 1+ leftNumber + rightNumber;
	}

	@Override
	public int getHeight() {
		return getHeight(this);
	}
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if(node!= null) {
			height = 1 + Math.max(getHeight(node.left),
					getHeight(node.right));
		}
		return height;
	}

	@Override
	public BinaryNodeInterface<T> copy() {
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if(left != null) {
			newRoot.left = (BinaryNode<T>)left.copy();
		}
		if(right != null) {
			newRoot.right = (BinaryNode<T>)right.copy();
		}
		return newRoot;
	}

}
