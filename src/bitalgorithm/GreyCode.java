package bitalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GreyCode {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(getGreyCode(n));
	}

	public static ArrayList<String> getGreyCode(int n) {
		if (n == 0) {
			return new ArrayList<String>();
		}
		if (n == 1) {
			return new ArrayList<>(Arrays.asList(new String[] { "0", "1" }));
		}
		ArrayList<String> prev = getGreyCode(n - 1);
		ArrayList<String> curr = new ArrayList<>();

		for (int i = 0; i < prev.size(); i++) {
			curr.add("0" + prev.get(i));
		}

		for (int i = prev.size() - 1; i >= 0; i--) {
			curr.add(prev.get(i) + "1");
		}
		return curr;
	}

}
