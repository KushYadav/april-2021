package dp;

public class ClimbStairMinimumMoves {

	public static void main(String[] args) {
		int n = 10;
		int[] jump = new int[] { 1, 1, 1, 4, 9, 8, 1, 1, 10, 1 };
		System.out.println(getMinimumMoves(n, jump));
	}

	public static int getMinimumMoves(int n, int[] jump) {
		Integer[] dp = new Integer[n + 1];
		dp[n] = 0;
		for (int i = n - 1; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= jump[i] && i + j <= n; j++) {
				min = Math.min(min, dp[i + j]);
			}
			if (min < Integer.MAX_VALUE) {
				dp[i] = min + 1;
			} else {
				dp[i] = Integer.MAX_VALUE;
			}
		}
		return dp[0];
	}
}
