package dp;

public class MinCostPaintHouse {

	public static void main(String[] args) {

		int n = 4;
		int[][] arr = new int[4][3];
		arr[0] = new int[] { 1, 5, 7 };
		arr[1] = new int[] { 5, 8, 4 };
		arr[2] = new int[] { 3, 2, 9 };
		arr[3] = new int[] { 1, 2, 4 };

		display(arr);
		int r = 0;
		int g = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			int xr = r;
			int xg = g;
			int xb = b;
			r = Math.min(xg, xb) + arr[i][0];
			g = Math.min(xb, xr) + arr[i][1];
			b = Math.min(xr, xg) + arr[i][2];
		}
		System.out.println(Math.min(Math.min(r, g), b));
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
