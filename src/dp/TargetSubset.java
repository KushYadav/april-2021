package dp;

public class TargetSubset {

	// Subarray: Continous (n*(n+1)/2)
	// 1,2,3 = 1,2,3,12,23,123

	// Subsets: Non Continous(2^n)
	// 1,2,3 = ,1,2,3,12,13,23,123

	public static void main(String[] args) {

		int n = 10;
		int[] arr = new int[] { 4, 2, 7, 1, 3 };

		boolean[][] dp = new boolean[arr.length + 1][n + 1];
		dp[0][0] = true;

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 0; j <= n; j++) {
				if (dp[i - 1][j]) {
					dp[i][j] = true;
				}
				if (j >= arr[i - 1] && dp[i - 1][j - arr[i - 1]]) {
					dp[i][j] = true;
				}
			}
		}
		display(dp);
		System.out.println(dp[arr.length][n]);
	}

	public static void display(boolean[][] plane) {
		for (int i = 0; i < plane.length; i++) {
			for (int j = 0; j < plane[0].length; j++) {
				System.out.print(plane[i][j] + "	");
			}
			System.out.println();
		}
	}

}
