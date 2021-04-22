package dp;

public class CountAlphabetEncoding {

	public static void main(String[] args) {

		String code = "101111";
		int[] dp = new int[code.length() + 1];
		dp[0] = 1;
		display(dp);

		for (int i = 1; i < dp.length; i++) {
			if (i >= 2) {
				int ai = Integer.valueOf(code.substring(i - 2, i));
				if (code.substring(i - 2, i - 1).equals("0") && code.substring(i - 1, i).equals("0")) {
					dp[i] = 0;
				} else if (code.substring(i - 2, i - 1).equals("0")) {
					dp[i] = dp[i - 1];
				} else if (code.substring(i - 1, i).equals("0")) {
					if (ai > 26) {
						dp[i] = 0;
					} else {
						dp[i] = dp[i - 2];
					}
				} else {
					if (ai > 26) {
						dp[i] = dp[i - 1];
					} else {
						dp[i] = dp[i - 1] + dp[i - 2];
					}
				}
			} else {
				if (!code.substring(i - 1, i).equals("0")) {
					dp[i] = 1;
				}
			}
		}
		display(dp);
		System.out.println(dp[dp.length - 1]);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
