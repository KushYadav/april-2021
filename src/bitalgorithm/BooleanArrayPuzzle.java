package bitalgorithm;

import java.util.Scanner;

public class BooleanArrayPuzzle {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[2];

		for (int i = 0; i < 2; i++) {
			arr[i] = scn.nextInt();
		}

		arr[arr[1]] = arr[arr[0]];

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

}
