package bitalgorithm;

import java.util.Scanner;

public class IsPowerOf4 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		if ((n != 0) && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
