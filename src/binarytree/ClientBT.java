package binarytree;

public class ClientBT {

	// 50 true 25 true 12 false false true 37 true 30 false false true 40 false false true 75 true 62 true 60 false false true 70 false false true 87 false false

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.display();
		System.out.println(bt.isEmpty());
		System.out.println(bt.size());
		System.out.println(bt.sizeR());
		System.out.println(bt.find(87));
		System.out.println(bt.find(88));
		System.out.println(bt.max());
		System.out.println(bt.height());
		bt.preOrder();
		bt.inOrder();
		bt.postOrder();
		bt.levelOrder();

	}

}
