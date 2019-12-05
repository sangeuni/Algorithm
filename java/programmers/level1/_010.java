package programmers.level1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _010 {
	/*
	 * Level1 - 모의고사
	 *
	 */
	public int[] solution(int[] answers) {
		int[] answer;
		int[] result = new int[3];

		Queue<Integer> one = new LinkedList<>();
		Queue<Integer> two = new LinkedList<>();
		Queue<Integer> three = new LinkedList<>();

		one.offer(1);
		one.offer(2);
		one.offer(3);
		one.offer(4);
		one.offer(5);

		two.offer(2);
		two.offer(1);
		two.offer(2);
		two.offer(3);
		two.offer(2);
		two.offer(4);
		two.offer(2);
		two.offer(5);

		three.offer(3);
		three.offer(3);
		three.offer(1);
		three.offer(1);
		three.offer(2);
		three.offer(2);
		three.offer(4);
		three.offer(4);
		three.offer(5);
		three.offer(5);

		int mark1, mark2, mark3;
		for (int i = 0; i < answers.length; i++) {
			mark1 = one.poll();
			mark2 = two.poll();
			mark3 = three.poll();

			if (mark1 == answers[i])
				result[0]++;
			one.offer(mark1);

			if (mark2 == answers[i])
				result[1]++;
			two.offer(mark2);

			if (mark3 == answers[i])
				result[2]++;
			three.offer(mark3);
		}

		int max = result[0];
		for (int i = 0; i < result.length; i++) {
			if (max < result[i])
				max = result[i];
		}
		List<Integer> win = new ArrayList<>();

		for (int i = 0; i < result.length; i++) {
			if (max == result[i]) {
				win.add(i);
			}
		}

		answer = new int[win.size()];

		for (int i = 0; i < win.size(); i++) {
			answer[i] = win.get(i) + 1;
		}
		return answer;
	}
}
