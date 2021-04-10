package bitalgorithm;

import java.util.Scanner;

public class SetBitsInAnArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int totalSetBits = 0;

		for (int i = 0; i < arr.length; i++) {
			totalSetBits += getSetBits(arr[i]);
		}
		
		System.out.println(totalSetBits);
	}

	public static int getSetBits(int n) {
		int counter = 0;
		while (n != 0) {
			int rbsm = n & -n;
			n = n - rbsm;
			counter++;
		}
		return counter;
	}

}
