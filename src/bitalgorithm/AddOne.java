package bitalgorithm;

import java.util.Scanner;

public class AddOne {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int c = n;
		int m = 1;

		while ((c & 1) == 1) {
			n ^= m;
			m <<= 1;
		}
		n ^= m;
		System.out.println(n);
	}

}
