package programmers.level1;

public class _002 {
	/*
	 * Level1 - 2016년
	 *
	 */

	public String solution(int a, int b) {
		String answer = "";
		String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };
		int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int day = 0;
		for (int i = 1; i < a; i++) {
			day += month[i];
		}
		day += b;
		answer = week[day % 7];
		return answer;
	}
}
