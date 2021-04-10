package bitalgorithm;

import java.util.Scanner;

public class ClosestLargerWithSameSetBits {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int c = n;
		int c0 = 0;
		int c1 = 0;

		while ((c & 1) == 0 && c != 0) {
			c0++;
			c >>= 1;
		}

		while ((c & 1) == 1) {
			c1++;
			c >>= 1;
		}
		int p = c0 + c1;

		if (p == 0) {
			System.out.println(0);
		} else if (p == 31) {
			System.out.println(n);
		} else {
			n |= (1 << p);
			n &= ~((1 << p) - 1);
			n |= (1 << (c1 - 1)) - 1;

			System.out.println(n);
		}
	}
}
