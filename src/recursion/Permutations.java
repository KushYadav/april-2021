package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Permutations {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();
		System.out.println(getPermutations(s));
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			return new ArrayList<String>(Arrays.asList(new String[] { "" }));
		}
		
		char ch = str.charAt(0);
		ArrayList<String> ol = getPermutations(str.substring(1));
		ArrayList<String> nl = new ArrayList<String>();

		for (String ss : ol) {
			for (int i = 0; i <= ss.length(); i++) {
				StringBuilder sb = new StringBuilder(ss);
				nl.add(sb.insert(i, ch).toString());
			}
		}
		return nl;
	}

}
