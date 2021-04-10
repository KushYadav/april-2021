package bitalgorithm;

import java.util.Scanner;

public class MultiplyTwoNumbers {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();

		int count = 0;
		int ans = 0;

		while (b != 0) {
			if ((b & 1) == 1) {
				ans = getSum(ans, a << count);
			}
			count++;
			b >>= 1;
		}
		System.out.println(ans);
	}

	public static int getSum(int a, int b) {
		if (b == 0) {
			return a;
		}
		return getSum(a ^ b, (a & b) << 1);
	}

}
