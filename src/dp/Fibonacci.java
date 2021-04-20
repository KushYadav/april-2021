package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Fibonacci {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.valueOf(br.readLine());
		System.out.println(fibMemoized(a, new int[a + 1]));
		System.out.println(fibTabulation(a));
	}

	public static int fibMemoized(int n, int[] qb) {
		if (n == 0 || n == 1) {
			return n;
		}
		if (qb[n] != 0) {
			return qb[n];
		}
		int fibN = fibMemoized(n - 1, qb) + fibMemoized(n - 2, qb);
		qb[n] = fibN;
		return fibN;
	}

	public static int fibTabulation(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
}
