/*
Creating Balanced Binary Trees
*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArray = {10,20,30,12,5,23,58,9};
		//Node root = new Node(null);
		Node root = BinaryTreeFactory.getInstance().createBinaryTree(intArray);
		System.out.println(root.toString());
	}

}
