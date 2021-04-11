package bitalgorithm;

import java.util.Scanner;

public class SwapTwoNibble {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		byte b = scn.nextByte();
		System.out.println((b & 0x0F) << 4 | (b & 0xF0) >> 4);
	}
}
