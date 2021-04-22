package dp;

public class NoConsecutiveZeroes {

	public static void main(String[] args) {
		int n = 6;
		int zero = 0;
		int one = 0;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				zero = one = 1;
			} else {
				one = zero + (zero = one);
			}
		}
		System.out.println(zero + one);
	}
}
