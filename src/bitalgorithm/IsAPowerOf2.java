package bitalgorithm;

import java.util.Scanner;

public class IsAPowerOf2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println((n != 0) && (n & (n - 1)) == 0 ? "YES" : "NO");
	}
}
