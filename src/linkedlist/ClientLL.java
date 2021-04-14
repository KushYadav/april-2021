package linkedlist;

public class ClientLL {

	public static void main(String[] args) {

		CustomLinkedList cll = new CustomLinkedList();
		cll.add(0, 10);
		cll.add(1, 20);
		cll.add(1, 30);
		cll.add(2, 40);
		cll.add(2, 50);

		cll.display();
		cll.displayR();

//		System.out.println(cll.remove(3));
//		System.out.println(cll.remove(2));
//		System.out.println(cll.remove(1));
//		System.out.println(cll.remove(1));
//		System.out.println(cll.remove(0));

		cll.reverseDataI();
		cll.display();
		cll.reverseDataR();
		cll.display();
		cll.reversePointerI();
		cll.display();
		cll.reversePointerR();
		cll.display();

	}
}
