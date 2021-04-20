package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CountPath {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		System.out.println(cpMemoized(n, new int[n + 1]));
		System.out.println(cpTabulation(n));
	}

	public static int cpMemoized(int n, int[] qb) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (qb[n] != 0) {
			return qb[n];
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			count += cpMemoized(n - i, qb);
		}
		qb[n] = count;
		return count;
	}

	public static int cpTabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			int count = 0;
			for (int j = 1; j <= 6; j++) {
				if (i - j >= 0) {
					count += dp[i - j];
				}
			}
			dp[i] = count;
		}
		return dp[n];
	}
}
