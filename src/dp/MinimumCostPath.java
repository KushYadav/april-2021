package dp;

public class MinimumCostPath {

	public static void main(String[] args) {

		int[][] world = new int[7][7];
		world[0] = new int[] { 2, 8, 4, 1, 6, 4, 2 };
		world[1] = new int[] { 6, 0, 9, 5, 3, 8, 5 };
		world[2] = new int[] { 1, 4, 3, 4, 0, 6, 5 };
		world[3] = new int[] { 6, 4, 7, 2, 4, 6, 1 };
		world[4] = new int[] { 1, 0, 3, 7, 1, 2, 7 };
		world[5] = new int[] { 1, 5, 3, 2, 3, 0, 9 };
		world[6] = new int[] { 2, 2, 5, 1, 9, 8, 2 };
		display(world);

		int[][] dp = new int[world.length][world[0].length];
		for (int i = world.length - 1; i >= 0; i--) {
			for (int j = world[0].length - 1; j >= 0; j--) {
				if (i + 1 == world.length && j + 1 == world[0].length) {
					dp[i][j] = world[i][j];
				} else if (j + 1 == world[0].length) {
					dp[i][j] = world[i][j] + dp[i + 1][j];
				} else if (i + 1 == world.length) {
					dp[i][j] = world[i][j] + dp[i][j + 1];
				} else {
					dp[i][j] = world[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
				}
			}
		}
		System.out.println(dp[0][0]);
	}

	public static void display(int[][] world) {
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[0].length; j++) {
				System.out.print(world[i][j] + " ");
			}
			System.out.println();
		}
	}

}
