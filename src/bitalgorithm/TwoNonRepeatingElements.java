package bitalgorithm;

import java.util.Scanner;

public class TwoNonRepeatingElements {

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

		ans = ans & -ans;
		int a = 0;
		int b = 0;

		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & ans) > 0) {
				a ^= arr[i];
			} else {
				b ^= arr[i];
			}
		}
		System.out.println(a + " " + b);
	}

}
