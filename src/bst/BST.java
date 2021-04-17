package bst;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;

		public Node() {

		}

		public Node(int data) {
			this.data = data;
		}
	}

	// Required Variables

	private Node root;
	private int size;

	// Constructing tree using an array

	private Node construct(int[] arr, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int mid = (lo + hi) / 2;
		Node node = new Node();
		node.data = arr[mid];
		node.left = construct(arr, lo, mid - 1);
		node.right = construct(arr, mid + 1, hi);
		return node;
	}

	public void construct(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
		size = arr.length;
	}

	// Basic Functions

	private void display(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.left == null ? " " : node.left.data);
		System.out.print("<=" + node.data + "=>");
		System.out.println(node.right == null ? " " : node.right.data);
		display(node.left);
		display(node.right);
	}

	public void display() {
		display(root);
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public int size() {
		return size;
	}

	private int sizeR(Node node) {
		if (node == null) {
			return 0;
		}
		return sizeR(node.left) + sizeR(node.right) + 1;
	}

	public int sizeR() {
		return sizeR(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return Math.max(height(node.left), height(node.right)) + 1;
	}

	public int height() {
		return height(root);
	}

	public int min() {
		Node trav = root;
		while (trav.left != null) {
			trav = trav.left;
		}
		return trav.data;
	}

	public int max() {
		Node trav = root;
		while (trav.right != null) {
			trav = trav.right;
		}
		return trav.data;
	}

	public boolean find(int data) {
		Node trav = root;
		while (trav != null) {
			if (trav.data == data) {
				return true;
			}
			if (data > trav.data) {
				trav = trav.right;
			} else {
				trav = trav.left;
			}
		}
		return false;
	}

	// Add Node

	public void addNode(Node node, int data) {
		if (data < node.data && node.left == null) {
			Node nNode = new Node(data);
			node.left = nNode;
			return;
		}
		if (data > node.data && node.right == null) {
			Node nNode = new Node(data);
			node.right = nNode;
			return;
		}
		if (data > node.data) {
			addNode(node.right, data);
		} else {
			addNode(node.left, data);
		}
	}

	public void addNode(int data) {
		addNode(root, data);
	}
}
