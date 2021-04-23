package dp;

public class MinCostPaintHouseManyColors {

	public static void main(String[] args) {

		int houses = 4;
		int colors = 3;

		int[][] arr = new int[houses][colors];

		arr[0] = new int[] { 1, 5, 7, 2, 1, 4 };
		arr[1] = new int[] { 5, 8, 4, 3, 6, 1 };
		arr[2] = new int[] { 3, 2, 9, 7, 2, 3 };
		arr[3] = new int[] { 1, 2, 4, 9, 1, 7 };

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] += min(arr, i - 1, j);
			}
		}
		System.out.println(min(arr, arr.length - 1, -1));
	}

	public static int min(int[][] arr, int i, int skip) {
		int min = Integer.MAX_VALUE;
		for (int k = 0; k < arr[0].length; k++) {
			if (k == skip) {
				continue;
			}
			if (arr[i][k] < min) {
				min = arr[i][k];
			}
		}
		return min;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "	");
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
}
