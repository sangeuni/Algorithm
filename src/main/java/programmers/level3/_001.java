package programmers.level3;

public class _001 {
	/*
	 * Level3 - 124 나라의 숫자
	 *
	 */
	public String solution(int n) {
		String answer = "";
		while (n > 0) {
			if (n % 3 == 0) {
				String four = "4";
				four += answer;
				answer = four;
				n = n / 3 - 1;
			} else {
				String temp = Integer.toString(n % 3);
				temp += answer;
				answer = temp;
				n = n / 3;
			}
		}
		return answer;
	}
}
