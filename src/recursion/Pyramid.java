package recursion;

import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		printPyramid(n, n - 1, 1);
	}

	public static void printPyramid(int n, int spaces, int stars) {
		if (spaces < 0) {
			return;
		}
		for (int i = 0; i < spaces; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < stars; i++) {
			System.out.print("*");
		}
		for (int i = 0; i < spaces; i++) {
			System.out.print(" ");
		}
		System.out.println();
		printPyramid(n, spaces - 1, stars + 2);

	}

}
