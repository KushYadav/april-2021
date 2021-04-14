package linkedlist;

public class CustomLinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

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

}
