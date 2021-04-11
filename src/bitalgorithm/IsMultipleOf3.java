package bitalgorithm;

import java.util.Scanner;

public class IsMultipleOf3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		while (true) {
			int odd = n & 0x55555555;
			int even = n & 0xAAAAAAAA;

			int oddCount = countBits(odd);
			int evenCount = countBits(even);

			n = oddCount - evenCount;
			n = ((n >> 31) + n) ^ (n >> 31);

			if ((n & 1) == 0) {
				System.out.println("YES");
				break;
			} else if ((n & 1) == 1 && n >> 1 == 0) {
				System.out.println("NO");
				break;
			}
		}
	}

	public static int countBits(int n) {
		int count = 0;
		while (n != 0) {
			int rsbm = n & -n;
			n ^= rsbm;
			count++;
		}
		return count;
	}

}
