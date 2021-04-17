package bst;

public class ClientBST {
	public static void main(String[] args) {

		int[] arr = new int[] { 11, 23, 25, 30, 31, 35, 42, 50, 70, 73, 80, 85 };
		BST bst = new BST();
		bst.construct(arr);
		bst.display();
//		System.out.println(bst.size());
//		System.out.println(bst.sizeR());
//		System.out.println(bst.height());
//		System.out.println(bst.min());
//		System.out.println(bst.max());
//		System.out.println(bst.find(23));
//		bst.addNode(10);
//		bst.display();
		bst.removeNode(70);
		bst.display();
	}
}
