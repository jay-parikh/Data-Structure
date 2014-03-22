/*
Creating Balanced Binary Trees
*/
public class Node<Type> {
	private Node<Type> root;
	private Node<Type> leftChild;
	private Node<Type> rightChild;
	private Type value;
	
	public Type getValue(){
		return value;
	}
	
	public void setValue(Type value){
		this.value=value;
	}
	
	public Node(Node<Type> _root){
		root=_root;
	}
	
	public Node<Type> getRoot(){
		return root;
	}
	
	public void setRoot(Node<Type> root){
		this.root = root;
	}
	
	public Node<Type> getLeftChild(){
		return this.leftChild;
	}
	
	public void setLeftChild(Node<Type> leftChild){
		this.leftChild = leftChild;
	}
	
	public Node<Type> getRightChild(){
		return this.rightChild;
	}
	
	public void setRightChild(Node<Type> rightChild){
		this.rightChild = rightChild;
	}
	
	public String toString(){
		
		String res = new String("("+value+",");
		if (this.getLeftChild()!=null){
			Node<Type>lc = this.getLeftChild();
			res=res+lc.toString();
		}
		res = res+",";
		if (this.getRightChild()!=null){
			Node<Type>rc = this.getRightChild();
			res=res+rc.toString();
		}
		res = res+")";
		return res;
	}
}
