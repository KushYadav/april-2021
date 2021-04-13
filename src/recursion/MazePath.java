package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazePath {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int rows = scn.nextInt();
		int cols = scn.nextInt();
		System.out.println(getMazePath(0, 0, rows, cols));
		printMazePath(0, 0, rows, cols, "");
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {
		if (cr == er && cc == ec) {
			return new ArrayList<String>(Arrays.asList(new String[] { "" }));
		}
		ArrayList<String> nl = new ArrayList<String>();
		if (cr + 1 <= er) {
			ArrayList<String> ol = getMazePath(cr + 1, cc, er, ec);
			for (String ss : ol) {
				nl.add("H" + ss);
			}
		}
		if (cc + 1 <= ec) {
			ArrayList<String> ol = getMazePath(cr, cc + 1, er, ec);
			for (String ss : ol) {
				nl.add("V" + ss);
			}
		}
		return nl;

	}

	public static void printMazePath(int cr, int cc, int er, int ec, String psf) {
		if (cr == er && cc == ec) {
			System.out.print(psf + " ");
			return;
		}
		if (cr <= er) {
			printMazePath(cr + 1, cc, er, ec, psf + "H");
		}
		if (cc <= ec) {
			printMazePath(cr, cc + 1, er, ec, psf + "V");
		}
	}

}
