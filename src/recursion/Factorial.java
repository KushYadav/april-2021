package recursion;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		System.out.println(getFactorial(n));
	}

	private static long getFactorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * getFactorial(n - 1);
	}
}
