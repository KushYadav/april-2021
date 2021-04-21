package dp;

public class CoinPermutationSum {

	public static void main(String[] args) {

		int sum = 10;
		int[] arr = new int[] { 2, 3, 5, 6 };

		int dp[] = new int[sum + 1];
		System.out.println(dp.length);
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i >= arr[j]) {
					dp[i] += dp[i - arr[j]];
				}
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
