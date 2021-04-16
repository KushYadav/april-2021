package generictree;

public class ClientGT {

	// 10 3 20 2 50 0 60 0 30 3 70 0 80 0 90 0 40 1 100 0

	public static void main(String[] args) {

		GenericTree gt = new GenericTree();
		gt.display();
		System.out.println(gt.size());
		System.out.println(gt.sizeR());
		System.out.println(gt.maxR());
		System.out.println(gt.height());
		System.out.println(gt.find(90));
		System.out.println(gt.find(900));
//		gt.mirror();
//		gt.display();
//		gt.printAtDepth(2);
		gt.linearize();
		gt.display();
	}
}
