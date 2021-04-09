package bitalgorithm;

import java.util.Scanner;

public class AddTwoNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(getSum(a, b));
	}

	private static int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getSum(a ^ b, (a & b) << 1);
	}

}
