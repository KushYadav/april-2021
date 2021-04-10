package bitalgorithm;

import java.util.Scanner;

public class BitRotation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int d = scn.nextInt();

		System.out.println(leftRotation(n, d));
		System.out.println(rightRotation(n, d));
	}

	public static int rightRotation(int n, int d) {
		return (n >>> d) | (n << (32 - d));
	}

	public static int leftRotation(int n, int d) {
		return (n >>> (32 - d) | (n << d));
	}

}
