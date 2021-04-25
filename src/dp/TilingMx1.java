package dp;

import java.util.Scanner;

public class TilingMx1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();

		int[] dp = new int[n + 1];
		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {
			if (i < m) {
				dp[i] = dp[i - 1];
			} else {
				dp[i] = dp[i - 1] + dp[i - m];
			}
		}
		System.out.println(dp[dp.length - 1]);
	}
}
