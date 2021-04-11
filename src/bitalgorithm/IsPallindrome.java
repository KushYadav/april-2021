package bitalgorithm;

import java.util.Scanner;

public class IsPallindrome {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int p = 0;
		int c = n;
		int counter = 0;
		while (c != 0) {
			counter++;
			if ((c & 1) == 1) {
				p = counter;
			}
			c >>>= 1;
		}
		System.out.println(Integer.toBinaryString(n));

		boolean isPallindrome = true;

		for (int i = 0; i <= p / 2; i++) {
			if ((((n >>> i) & 1) ^ (n >>> (p - 1 - i) & 1)) != 0) {
				isPallindrome = false;
				break;
			}
		}
		System.out.println(isPallindrome ? "YES" : "NO");
	}
}
