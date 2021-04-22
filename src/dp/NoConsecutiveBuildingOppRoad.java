package dp;

public class NoConsecutiveBuildingOppRoad {

	public static void main(String[] args) {
		int n = 6;
		int building = 0;
		int space = 0;

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				building = space = 1;
			} else {
				building = space + (space = building);
			}
		}
		int combinations = building + space;
		System.out.println(combinations * combinations);
	}
}
