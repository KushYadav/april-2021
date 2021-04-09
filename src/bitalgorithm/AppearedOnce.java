package bitalgorithm;

public class AppearedOnce {

	// Given an array where every element occurs three times, except one element
	// which occurs only once. Find the element that occurs once. Expected time
	// complexity is O(n) and O(1) extra space.

	public static void main(String[] args) {

		int[] arr = new int[] { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };

		int tn = Integer.MAX_VALUE;
		int tnp1 = 0;
		int tnp2 = 0;

		for (int i = 0; i < arr.length; i++) {
			int cwtn = arr[i] & tn;
			int cwtnp1 = arr[i] & tnp1;
			int cwtnp2 = arr[i] & tnp2;

			tn = tn & (~cwtn);
			tnp1 = tnp1 | cwtn;

			tnp1 = tnp1 & (~cwtnp1);
			tnp2 = tnp2 | cwtnp1;

			tnp2 = tnp2 & (~cwtnp2);
			tn = tn | cwtnp2;
		}

		System.out.println(tnp1);

	}
}
