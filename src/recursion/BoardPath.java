package recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardPath {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(getPaths(a, b));
		printBoardPath(a, b, "");
	}

	public static ArrayList<String> getPaths(int curr, int end) {
		ArrayList<String> bl = new ArrayList<String>();
		if (curr == end) {
			bl.add("");
			return bl;
		}
		ArrayList<String> nl = new ArrayList<String>();
		for (int dice = 1; dice <= 6; dice++) {
			if (curr + dice <= end) {
				ArrayList<String> ol = getPaths(curr + dice, end);
				for (String ss : ol) {
					nl.add(dice + ss);
				}
			}
		}
		return nl;
	}

	public static void printBoardPath(int curr, int end, String psf) {
		if (curr == end) {
			System.out.print(psf + " ");
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			if (dice + curr <= end) {
				printBoardPath(curr + dice, end, psf + dice);
			}
		}
	}
}
