package bitalgorithm;

import java.util.Scanner;

public class FlipToConvertAtoB {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();

		int ans = a ^ b;
		System.out.println(countBits(ans));

	}

	public static int countBits(int n) {

		int count = 0;
		while (n != 0) {
			int rsbm = n & -n;
			n ^= rsbm;
			count++;
		}
		return count;
	}

}
