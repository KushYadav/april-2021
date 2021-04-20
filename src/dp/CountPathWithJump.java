package dp;

public class CountPathWithJump {
	public static void main(String[] args) {
		int n = 6;
		int[] jump = new int[] { 2, 3, 0, 2, 2, 3 };
		System.out.println(cpjTabulation(n, jump));
	}

	public static int cpjTabulation(int n, int[] jump) {
		int[] dp = new int[n + 1];
		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			int count = 0;
			for (int j = 1; j <= jump[i]; j++) {
				if (i + j < dp.length) {
					count += dp[i + j];
				}
			}
			dp[i] = count;
		}
		return dp[0];
	}
}
