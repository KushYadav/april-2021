package dp;

public class GoldMine {

	public static void main(String[] args) {

		int[][] world = new int[6][6];
		world[0] = new int[] { 0, 1, 4, 2, 8, 2 };
		world[1] = new int[] { 4, 3, 6, 5, 0, 4 };
		world[2] = new int[] { 1, 2, 4, 1, 4, 6 };
		world[3] = new int[] { 2, 0, 7, 3, 2, 2 };
		world[4] = new int[] { 3, 1, 5, 9, 2, 4 };
		world[5] = new int[] { 2, 7, 0, 8, 5, 1 };
		display(world);
		int[][] dp = new int[world.length][world[0].length];

		for (int j = world[0].length - 1; j >= 0; j--) {
			for (int i = world.length - 1; i >= 0; i--) {
				if (j == world[0].length - 1) {
					dp[i][j] = world[i][j];
				} else if (i == world.length - 1) {
					dp[i][j] = world[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
				} else if (i == 0) {
					dp[i][j] = world[i][j] + Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
				} else {
					dp[i][j] = world[i][j] + Math.max(dp[i - 1][j + 1], Math.max(dp[i][j + 1], dp[i + 1][j + 1]));
				}
			}
		}

		int max = 0;
		int idx = 0;
		for (int i = 0; i < world.length; i++) {
			if (max < dp[i][0]) {
				max = dp[i][0];
				idx = i;
			}
		}

		display(dp);
		System.out.println("MAX GOLD: " + max);

		String weightPath = "";
		String sumPath = "";
		System.out.println();

		for (int j = 0; j < world[0].length - 1; j++) {
			weightPath += world[idx][j] + " ";
			sumPath += dp[idx][j] + " ";

			int cm = dp[idx][j + 1];
			if (idx == 0) {
				if (cm < dp[idx + 1][j + 1]) {
					idx += 1;
				}
			} else if (idx == dp.length - 1) {
				if (cm < dp[idx - 1][j + 1]) {
					idx -= 1;
				}
			} else {
				if (cm < dp[idx + 1][j + 1] && dp[idx + 1][j + 1] > dp[idx - 1][j + 1]) {
					idx += 1;
				} else if (cm < dp[idx - 1][j + 1] && dp[idx - 1][j + 1] > dp[idx + 1][j + 1]) {
					idx -= 1;
				}
			}
		}

		weightPath += dp[idx][world[0].length - 1];
		sumPath += dp[idx][dp.length - 1];

		System.out.println("DP Path: " + sumPath);
		System.out.println("Gold Path: " + weightPath);
	}

	public static void display(int[][] world) {
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				System.out.print(world[i][j] + "	");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------");
	}
}
