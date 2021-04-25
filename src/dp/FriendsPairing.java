package dp;

import java.util.Scanner;

public class FriendsPairing {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] dp = new int[n + 1];

		for (int i = 1; i < dp.length; i++) {
			if (i == 1) {
				dp[i] = 1;
			} else if (i == 2) {
				dp[i] = 2;
			} else {
				dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
			}
		}
		System.out.println(dp[dp.length - 1]);
	}

}
