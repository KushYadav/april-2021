package linkedlist;

public class CustomLinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// Basic Functions

	public int size() {
		return size;
	}

	public int getFirst() {
		return head.data;
	}

	public int getLast() {
		return tail.data;
	}

	public Node getNode(int idx) {
		Node trav = head;
		while (idx >= 1) {
			trav = trav.next;
			idx--;
		}
		return trav;
	}

	public void addFirst(int data) {
		Node node = new Node();
		node.data = data;

		if (size == 0) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}

	public void addLast(int data) {
		Node node = new Node();
		node.data = data;
		if (size == 0) {
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}

	public void add(int idx, int data) {
		if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else {
			Node node = new Node();
			node.data = data;
			Node prev;
			prev = getNode(idx - 1);
			node.next = prev.next;
			prev.next = node;
			size++;
		}
	}

	public int removeFirst() {
		int removed = head.data;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			head = head.next;
		}
		size--;
		return removed;
	}

	public int removeLast() {
		int removed = tail.data;
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			Node newTail = getNode(size - 1);
			tail = newTail;
			newTail.next = null;
		}
		size--;
		return removed;
	}

	public int remove(int idx) {
		if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node pred = getNode(idx - 1);
			int removed = pred.next.data;
			pred.next = pred.next.next;
			size--;
			return removed;
		}
	}

	public void display() {
		Node trav = head;
		while (trav != null) {
			System.out.print(trav.data + " ");
			trav = trav.next;
		}
		System.out.println("\n=================");
	}

	private void displayR(Node node) {
		if (node == null) {
			System.out.println("\n=================");
			return;
		}
		System.out.print(node.data + " ");
		displayR(node.next);
	}

	public void displayR() {
		displayR(head);
	}

	// Reverse Data Iterative

	public void reverseDataI() {
		Node trav = head;
		for (int i = 0; i < size / 2; i++) {
			int temp = getNode(size - i - 1).data;
			getNode(size - i - 1).data = trav.data;
			trav.data = temp;
			trav = trav.next;
		}
	}

	// Reverse Data Recursive

	private class ReverseDataHM {
		Node node;
	}

	private void reverseDataR(Node node, ReverseDataHM hm, int idx) {
		if (node == null) {
			return;
		}
		reverseDataR(node.next, hm, idx + 1);
		if (idx > size / 2) {
			int temp = hm.node.data;
			hm.node.data = node.data;
			node.data = temp;
			hm.node = hm.node.next;
		}
	}

	public void reverseDataR() {
		ReverseDataHM hm = new ReverseDataHM();
		hm.node = head;
		reverseDataR(head, hm, 0);
	}

	// Reverse Pointer Iterative

	public void reversePointerI() {
		Node curr = head;
		Node next = head.next;
		while (next != null) {
			Node nextToNext = next.next;
			next.next = curr;
			curr = next;
			next = nextToNext;
		}
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}

	// Reverse Pointer Recursive

	private void reversePointerR(Node node) {
		if (node.next == null) {
			return;
		}
		reversePointerR(node.next);
		node.next.next = node;
	}

	public void reversePointerR() {
		reversePointerR(head);
		Node temp = head;
		head = tail;
		tail = temp;
		tail.next = null;
	}
}
