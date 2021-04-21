package dp;

public class CoinCombinationSum {

	public static void main(String[] args) {

		int sum = 12;
		int[] arr = new int[] { 1, 5, 10 };

		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i]; j < dp.length; j++) {
				dp[j] += dp[j - arr[i]];
			}
			display(dp);
		}
		System.out.println(dp[sum]);
	}

	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
