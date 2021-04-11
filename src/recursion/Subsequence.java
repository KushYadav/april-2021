package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Subsequence {

	// Total number of substrings = n*(n+1)/2 + 1(Empty String)
	// abc = "", "a", "b", "c", "ab", "bc", "abc"

	// Total number of subsequence = 2^n
	// abc = "", "a", "b", "c", "ab", "bc", "ac", "abc"

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.nextLine();

		System.out.println(getSubsequence(s));
	}

	public static ArrayList<String> getSubsequence(String str) {
		if (str.length() == 0) {
			return new ArrayList<String>(Arrays.asList(new String[] { "" }));
		}
		ArrayList<String> el = getSubsequence(str.substring(1));
		ArrayList<String> nl = new ArrayList<String>();
		for (String ss : el) {
			nl.add(ss);
			nl.add(str.substring(0, 1) + ss);
		}
		return nl;
	}
}
