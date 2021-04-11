package bitalgorithm;

import java.util.Scanner;

public class SwapTwoNumbers {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(a + " " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
	}

}
