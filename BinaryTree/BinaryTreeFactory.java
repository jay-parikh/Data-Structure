/*
Creating Balanced Binary Trees
*/

public class BinaryTreeFactory {
	private static BinaryTreeFactory instance;
	private BinaryTreeFactory(){
	}
	static BinaryTreeFactory getInstance(){
		if (instance==null){
			instance = new BinaryTreeFactory();
		}
		return instance;
	}
	
	private <Type> void addChildren(Type[] array, int index,Node<Type> node){
		int leftChild = (index+1)*2;
		int rightChild = (index+1)*2 +1;
		leftChild--;
		rightChild--;
		if(leftChild<array.length){
			Node<Type> lc = new Node<Type>(null);
			lc.setValue(array[leftChild]);
			node.setLeftChild(lc);
			lc.setRoot(node.getRoot());
			addChildren(array,leftChild,lc);
		}
		if(rightChild<array.length){
			Node<Type> rc = new Node<Type>(null);
			rc.setValue(array[rightChild]);
			node.setRightChild(rc);
			rc.setRoot(node.getRoot());
			addChildren(array,rightChild,rc);
		}
		
	}
	
	public <Type> Node createBinaryTree(Type[] array){
		Node<Type> root = new Node<Type>(null);
		if(array!=null && array.length>0){
			root.setValue(array[0]);
		}
		addChildren(array,0,root);
		return root;
	}
}
