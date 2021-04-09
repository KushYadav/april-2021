package bitalgorithm;

import java.util.Scanner;

public class OnBitsTillN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(count(n));
	}

	public static int count(int n) {
		if (n == 0) {
			return 0;
		}

		int x = getLargestPowerOf2(n);
		int bTill2px = x * (1 << (x - 1));
		int remainingBits = n - (1 << x) + 1;
		int rest = n - (1 << x);

		return bTill2px + remainingBits + count(rest);
	}

	public static int getLargestPowerOf2(int n) {
		int x = 0;
		while ((1 << x) <= n) {
			x++;
		}
		return x - 1;
	}

}
