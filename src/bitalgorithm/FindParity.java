package bitalgorithm;

import java.util.Scanner;

public class FindParity {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int parity = 0;

		while (n != 0) {
			parity ^= 1;
			n &= (n - 1);
		}
		System.out.println(parity);

		System.out.println(parity == 0 ? "EVEN" : "ODD");

	}
}
