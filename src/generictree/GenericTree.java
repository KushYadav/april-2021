package generictree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

	// Mirror

	private void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}
		Collections.reverse(node.children);
	}

	public void mirror() {
		mirror(root);
	}

	// Print At Depth

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

	// Linearize

	private void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {
			Node ln = node.children.get(node.children.size() - 1);
			Node sln = node.children.get(node.children.size() - 2);
			while (sln.children.size() > 0) {
				sln = sln.children.get(0);
			}
			sln.children.add(ln);
			node.children.remove(node.children.get(node.children.size() - 1));
		}
	}

	public void linearize() {
		linearize(root);
	}

	// Flatten

	private void flatten(Node node) {
		ArrayList<Node> nc = new ArrayList<Node>();
		for (Node child : node.children) {
			flatten(child);
		}

		for (Node child : node.children) {
			nc.add(child);
			nc.addAll(child.children);
			child.children.clear();
		}
		node.children = nc;
	}

	public void flatten() {
		flatten(root);
	}

	// Pre-Order

	private void preOrder(Node node) {
		System.out.print(node.data + " ");
		for (Node child : node.children) {
			preOrder(child);
		}
	}

	public void preOrder() {
		System.out.print("Pre-Order: ");
		preOrder(root);
		System.out.println();
	}

	// Post-Order

	private void postOrder(Node node) {
		for (Node child : node.children) {
			postOrder(child);
		}
		System.out.print(node.data + " ");
	}

	public void postOrder() {
		System.out.print("Post-Order: ");
		postOrder(root);
		System.out.println();
	}

	// Remove Leaf

	private void removeLeaf(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			if (node.children.get(i).children.size() == 0) {
				node.children.remove(i);
			}
		}
		for (Node child : node.children) {
			removeLeaf(child);
		}
	}

	public void removeLeaf() {
		removeLeaf(root);
	}

	// Predecessor & Successor

	private Node pred;
	private Node succ;
	private int state;

	private void predSucc(Node node, int data) {
		if (state == 0) {
			if (node.data == data) {
				state = 1;
			} else {
				pred = node;
			}
		} else if (state == 1) {
			state = 2;
			succ = node;
		}
		for (Node child : node.children) {
			predSucc(child, data);
		}
	}

	public void predSucc(int data) {
		predSucc(root, data);
		System.out.println(pred.data);
		System.out.println(succ.data);
	}

	// Just Larger

	private Node justLarger;

	private void justLarger(Node node, int data) {
		if (node.data > data) {

			if (justLarger == null) {
				justLarger = node;
			} else if (node.data < justLarger.data) {
				justLarger = node;
			}
		}
		for (Node child : node.children) {
			justLarger(child, data);
		}
	}

	public int justLarger(int data) {
		justLarger(root, data);
		return justLarger == null ? Integer.MIN_VALUE : justLarger.data;
	}

	// Level Order

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast(root);
		while (queue.size() > 0) {
			Node removed = queue.removeFirst();
			System.out.println(removed.data);
			for (Node child : removed.children) {
				queue.addLast(child);
			}
		}
	}

	// Level Order Level-Wise

	public void levelOrderLW() {
		LinkedList<Node> queue1 = new LinkedList<Node>();
		LinkedList<Node> queue2 = new LinkedList<Node>();
		queue1.add(root);
		while (!queue1.isEmpty()) {
			Node removed = queue1.removeFirst();
			System.out.print(removed.data + " ");
			for (Node child : removed.children) {
				queue2.addLast(child);
			}
			if (queue1.size() == 0) {
				queue1 = queue2;
				queue2 = new LinkedList<>();
				System.out.println();
			}
		}
	}

	// Diameter

	private int[] diameter(Node node) {
		int diameter = 0;
		int h1 = -1;
		int h2 = -1;
		for (Node child : node.children) {
			int[] get = diameter(child);
			int cHeight = get[0];
			int cDiameter = get[1];
			if (cHeight > h1) {
				h1 = cHeight;
			} else if (cHeight > h2) {
				h2 = cHeight;
			}
			if (cDiameter > diameter) {
				diameter = cDiameter;
			}
		}
		return new int[] { Math.max(h1, h2) + 1, Math.max(diameter, h1 + h2 + 3) };
	}

	public int diameter() {
		return diameter(root)[1];
	}
}
