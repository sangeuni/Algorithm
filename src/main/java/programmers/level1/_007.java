package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _007 {
	/*
	 * Level1 - 나누어 떨어지는 숫자 배열
	 */
	public int[] solution(int[] array, int divisor) {
		int[] answer;
		Arrays.sort(array);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % divisor == 0) {
				list.add(array[i]);
			}
		}
		if (list.size() > 0) {
			answer = new int[list.size()];
			for (int i = 0; i < list.size(); i++) {
				answer[i] = list.get(i);
			}
			return answer;
		} else {
			answer = new int[] { -1 };
			return answer;
		}
	}
}
