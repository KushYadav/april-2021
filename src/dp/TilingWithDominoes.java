package dp;

import java.util.Scanner;

public class TilingWithDominoes {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] dp = new int[n + 2];

		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[dp.length - 1]);
	}
}