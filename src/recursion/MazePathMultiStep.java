package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MazePathMultiStep {

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
		for (int i = 1; i <= er - cr; i++) {
			ArrayList<String> ol = getMazePath(cr + i, cc, er, ec);
			for (String ss : ol) {
				nl.add("H" + i + ss);
			}
		}

		for (int i = 1; i <= ec - cc; i++) {
			ArrayList<String> ol = getMazePath(cr, cc + i, er, ec);
			for (String ss : ol) {
				nl.add("V" + i + ss);
			}
		}

		for (int i = 1; i <= ec - cc && i <= er - cr; i++) {
			ArrayList<String> ol = getMazePath(cr + i, cc + i, er, ec);
			for (String ss : ol) {
				nl.add("D" + i + ss);
			}
		}
		return nl;

	}

	public static void printMazePath(int cr, int cc, int er, int ec, String psf) {
		if (cr == er && cc == ec) {
			System.out.print(psf + " ");
			return;
		}
		for (int i = 1; i <= er - cr; i++) {
			printMazePath(cr + i, cc, er, ec, psf + "H" + i);
		}
		for (int i = 1; i <= ec - cc; i++) {
			printMazePath(cr, cc + i, er, ec, psf + "V" + i);
		}
		for (int i = 1; i <= ec - cc && i <= er - cr; i++) {
			printMazePath(cr + i, cc + i, er, ec, psf + "D" + i);
		}
	}

}
