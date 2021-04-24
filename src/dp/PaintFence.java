package dp;

public class PaintFence {

	public static void main(String[] args) {
		int n = 5;
		int k = 3;

		int ii = 0;
		int ij = 0;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				ij = 3;
			} else {
				ij = (ii + (ii = ij)) * (k - 1);
			}
		}
		System.out.println(ii + ij);
	}
}
