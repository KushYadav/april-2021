package dp;

public class AiBjCk {

	public static void main(String[] args) {

		String str = "abcabc";
		int a = 0;
		int ab = 0;
		int abc = 0;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				a = (a << 1) + 1;
				System.out.println(a);
			} else if (str.charAt(i) == 'b') {
				ab = (ab << 1) + a;
			} else if (str.charAt(i) == 'c') {
				abc = (abc << 1) + ab;
			}
		}
		System.out.println(abc);
	}
}
