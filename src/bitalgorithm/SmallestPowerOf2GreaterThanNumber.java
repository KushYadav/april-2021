package bitalgorithm;

import java.util.Scanner;

public class SmallestPowerOf2GreaterThanNumber {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int ans = 1;
		while (n != 0) {
			n >>>= 1;
			ans <<= 1;
		}
		System.out.println(ans);
	}

}
