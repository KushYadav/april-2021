package dp;

public class MaximumSumNonAdjucent {

	public static void main(String[] args) {

		int[] arr = new int[] { 5, 10, 10, 100, 5, 6 };
		int a = 0;
		int b = 0;

		for (int i = 0; i < arr.length; i++) {
			int xb = b;
			b = Math.max(a, b);
			a = xb + arr[i];
		}
		System.out.println(Math.max(a, b));
	}
}
