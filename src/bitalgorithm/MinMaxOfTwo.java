package bitalgorithm;

import java.util.Scanner;

public class MinMaxOfTwo {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();

		System.out.println(getMin(a, b));
		System.out.println(getMax(a, b));
	}

	public static int getMin(int a, int b) {
		return a ^ ((a ^ b) & ~((a - b) >> 31));
	}

	public static int getMax(int a, int b) {
		return a ^ ((a ^ b) & (a - b) >> 31);
	}

}
