package binarytree;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	// Required Variables

	private Node root;
	private int size;

	// Input

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, false, scn);
	}

	public Node takeInput(Node parent, boolean ilc, Scanner scn) {
		Node child = new Node();
		size++;
		child.data = scn.nextInt();
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			child.left = takeInput(child, true, scn);
		}
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			child.right = takeInput(child, false, scn);
		}
		return child;
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

	public boolean find(Node node, int data) {
		if (node == null) {
			return false;
		}
		return find(node.left, data) | find(node.right, data) | (node.data == data);
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(Math.max(max(node.left), max(node.right)), node.data);
	}

	public int max() {
		return max(root);
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

	// Pre-Order, In-Order, Post-Order

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void preOrder() {
		preOrder(root);
		System.out.println();
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}

	public void postOrder() {
		postOrder(root);
		System.out.println();
	}

	// Level Order

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			Node removed = queue.removeFirst();
			System.out.print(removed.data + " ");
			if (removed.left != null) {
				queue.addLast(removed.left);
			}
			if (removed.right != null) {
				queue.addLast(removed.right);
			}
		}
		System.out.println();
	}

	// Level Order LW

	public void levelOrderLW() {
		LinkedList<Node> queue1 = new LinkedList<Node>();
		LinkedList<Node> queue2 = new LinkedList<Node>();
		queue1.addLast(root);
		while (!queue1.isEmpty()) {
			Node removed = queue1.removeFirst();
			System.out.print(removed.data + " ");
			if (removed.left != null) {
				queue2.addLast(removed.left);
			}
			if (removed.right != null) {
				queue2.addLast(removed.right);
			}
			if (queue1.isEmpty()) {
				queue1 = queue2;
				queue2 = new LinkedList<Node>();
				System.out.println();
			}
		}
	}

	// Diameter

	public int[] diameter(Node node) {
		int dLeft = 0;
		int dRight = 0;
		int hLeft = -1;
		int hRight = -1;
		if (node.left != null) {
			int[] l = diameter(node.left);
			hLeft = l[0];
			dLeft = l[1];
		}
		if (node.right != null) {
			int[] r = diameter(node.right);
			hRight = r[0];
			dRight = r[1];
		}
		return new int[] { Math.max(hLeft, hRight) + 1, Math.max(Math.max(dLeft, dRight), hLeft + hRight + 3) };
	}

	public int diameter() {
		return diameter(root)[1];
	}
}