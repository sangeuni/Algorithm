package programmers.level2;

public class _006 {
	/*
	  * Leve2 - 카펫
	  *
	  * */
	public int[] solution(int brown, int red) {
		int[] answer = new int[2];
		int sum = brown + red;
		int temp;
		for (int i = 3; i <= sum; i++) {
			if (sum % i == 0) {
				temp = sum / i;
				if ((temp - 2) * (i - 2) == red) {
					answer[0] = temp;
					answer[1] = i;
					return answer;
				}
			}
		}
		return answer;
	}
}
