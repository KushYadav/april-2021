package bitalgorithm;

import java.util.Scanner;

public class ReverseBits {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));

		int count = 0;
		int ans = 0;

		while (n != 0) {
			ans |= (n & 1);
			ans <<= 1;
			n >>= 1;
			count++;
		}
		ans<<=(31-count);
		System.out.println(String.format("%32s", Integer.toBinaryString(ans)).replace(' ', '0'));

	}

}
