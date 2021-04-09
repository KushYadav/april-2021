package bitalgorithm;

import java.util.Scanner;

public class SwapBits {

	// Given a number x and two positions (from the right side) in the binary
	// representation of x, write a function that swaps n bits at given two
	// positions and returns the result. It is also given that the two sets of bits
	// do not overlap.
	
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = scn.nextInt();
		int b = scn.nextInt();

		System.out.println(swap(n, a, b));
	}

	public static int swap(int n, int a, int b) {
		if ((((n & (1 << a)) >> a) ^ ((n & (1 << b)) >> b)) == 1) { // Checking if the both bits are different
			n ^= (1 << a);
			n ^= (1 << b);
		}
		return n;
	}

}
