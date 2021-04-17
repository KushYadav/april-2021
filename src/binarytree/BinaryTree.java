package binarytree;

import java.util.Scanner;
import java.util.stream.Stream;

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

}
