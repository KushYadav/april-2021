package generictree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class GenericTree {

	public class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	// Required Variables

	private Node root;
	private int size;

	// Basic Functions

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, scn);
	}

	public Node takeInput(Node parent, Scanner scn) {
		Node child = new Node();
		child.data = scn.nextInt();
		size++;
		int noc = scn.nextInt();
		for (int i = 0; i < noc; i++) {
			child.children.add(takeInput(child, scn));
		}
		return child;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public void display(Node node) {
		System.out.print(node.data + " => ");
		for (Node child : node.children) {
			System.out.print(child.data + " ");
		}
		System.out.println();
		for (Node child : node.children) {
			display(child);
		}
	}

	public void display() {
		display(root);
	}

	// Supportive Functions

	private int sizeR(Node node) {
		int cs = 0;
		for (Node child : node.children) {
			cs += sizeR(child);
		}
		return cs + 1;
	}

	public int sizeR() {
		return sizeR(root);
	}

	private int maxR(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			max = Math.max(maxR(child), max);
		}
		return Math.max(max, node.data);
	}

	public int maxR() {
		return maxR(root);
	}

	private int height(Node node) {
		int height = -1;
		for (Node child : node.children) {
			height = Math.max(height, height(child));
		}
		return height + 1;
	}

	public int height() {
		return height(root);
	}

	private boolean find(Node node, int data) {
		boolean found = false;
		for (Node child : node.children) {
			found |= find(child, data);
		}
		return found | (node.data == data);
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}
		Collections.reverse(node.children);
	}

	public void mirror() {
		mirror(root);
	}

	private void printAtDepth(Node node, int currDepth, int depth) {
		if (currDepth == depth) {
			System.out.print(node.data + " ");
		}

		for (Node child : node.children) {
			printAtDepth(child, currDepth + 1, depth);
		}

	}

	public void printAtDepth(int depth) {
		printAtDepth(root, 0, depth);
	}

}
