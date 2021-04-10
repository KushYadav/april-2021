package bitalgorithm;

import java.util.Scanner;

public class IntegerOverflow {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int a = scn.nextInt();
		int b = scn.nextInt();

		int c = a + b;

		int a0 = a >>> 31;
		int b0 = b >>> 31;
		int c0 = c >>> 31;

		if ((a0 ^ b0) == 0 && (b0 ^ c0) == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

}
