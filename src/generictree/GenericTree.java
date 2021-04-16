package generictree;

import java.util.ArrayList;
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

}
