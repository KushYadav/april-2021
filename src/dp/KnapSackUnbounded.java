package dp;

public class KnapSackUnbounded {

	public static void main(String[] args) {
		int sum = 7;
		int[] weight = new int[] { 2, 5, 1, 3, 4 };
		int[] cost = new int[] { 15, 14, 10, 45, 30 };

		int[] dp = new int[sum + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < weight.length; j++) {
				if (i >= weight[j]) {
					dp[i] = Math.max(dp[i], dp[i - weight[j]] + cost[j]);
				}
			}
		}
		display(dp);
		System.out.println(dp[dp.length - 1]);
	}

	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
