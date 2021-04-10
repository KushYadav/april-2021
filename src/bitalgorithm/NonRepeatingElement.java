package bitalgorithm;

import java.util.Scanner;

public class NonRepeatingElement {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}

		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans ^= arr[i];
		}
		System.out.println(ans);
	}

}
