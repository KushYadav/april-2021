package bitalgorithm;

import java.util.Scanner;

public class GetAbsValue {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int intMask = n >> 31;

		System.out.println((intMask + n) ^ intMask);
	}

}
