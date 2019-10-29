package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _003 {
	/*
	 * Level1 - K번째 수
	 */
	public int[] solution(int[] arr, int[][] commands) {
		int[] answer = new int[commands.length];
		List<Integer> cut;

		for (int i = 0; i < commands.length; i++) {
			int first = commands[i][0];
			int last = commands[i][1];

			cut = cutArray(arr, first, last);
			Collections.sort(cut);
			answer[i] = cut.get(commands[i][2] - 1);
		}

		return answer;
	}

	public List<Integer> cutArray(int[] arr, int first, int last) {
		List<Integer> cut = new ArrayList<>();
		for (int i = first; i <= last; i++) {
			cut.add(arr[i - 1]);
		}
		return cut;
	}
}
