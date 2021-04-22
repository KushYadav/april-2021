package dp;

public class NoConsecutiveZeroes {

	public static void main(String[] args) {

		int n = 6;
		int ans = 0;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				ans += 1;
			} else {
				ans += 4;
			}
		}
		System.out.println(ans);
	}
}
