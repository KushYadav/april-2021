package recursion;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		System.out.println(getFibonacci(n));
	}

	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);

	}

}
