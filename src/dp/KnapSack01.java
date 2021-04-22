package dp;

public class KnapSack01 {

	public static void main(String[] args) {

		int sum = 7;
		int[] weight = new int[] { 2, 5, 1, 3, 4 };
		int[] cost = new int[] { 15, 14, 10, 45, 30 };

		int[][] dp = new int[weight.length + 1][sum + 1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j >= weight[i - 1]) {
					dp[i][j] = Math.max(dp[i][j], cost[i - 1] + dp[i - 1][j - weight[i - 1]]);
				}
			}
		}
		display(dp);
		System.out.println(dp[weight.length][sum]);

	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "	");
			}
			System.out.println();
		}
	}

}
