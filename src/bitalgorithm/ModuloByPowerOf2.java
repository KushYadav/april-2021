package bitalgorithm;

import java.util.Scanner;

public class ModuloByPowerOf2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int d = scn.nextInt();

		System.out.println((n & (d - 1)));
	}
}
