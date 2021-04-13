package recursion;

import java.util.Scanner;

public class FindIndexOfNumber {

	// 7 2 8 3 8 5 8 7

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(firstOccurance(arr, 8, 0));
		System.out.println(lastOccurance(arr, 8, 0));
	}

	public static int firstOccurance(int[] arr, int num, int vidx) {
		if (vidx == arr.length - 1) {
			return -1;
		}
		if (arr[vidx] == num) {
			return vidx;
		}
		int oi = firstOccurance(arr, num, vidx + 1);
		return oi;
	}

	public static int lastOccurance(int[] arr, int num, int vidx) {
		if (vidx == arr.length - 1) {
			return -1;
		}
		int oi = lastOccurance(arr, num, vidx + 1);
		if (arr[vidx] == num) {
			return Math.max(vidx, oi);
		}
		return oi;
	}

	public static void display(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
