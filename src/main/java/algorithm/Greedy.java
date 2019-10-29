package algorithm;

import java.util.Collections;
import java.util.LinkedList;

public class Greedy {
	public class Task implements Comparable<Task> {
		int num;
		int start;
		int end;

		public Task(int num, int start, int end) {
			this.num = num;
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Task o) {
			return this.end - o.end;
		}

	}

	public int[] go(int[][] arrays) {
		int[] answer = {};

		LinkedList<Task> list = new LinkedList<>();
		LinkedList<Task> result = new LinkedList<>();
		for (int i = 0; i < arrays.length; i++) {
			list.add(new Task(i + 1, arrays[i][1], arrays[i][2]));
		}

		// 끝나는 시간이 짧은 순으로 정렬
		Collections.sort(list);

		// 1. 해 선택 - 가장 빨리 끝나는 활동을 부분해 집합에 추가
		result.add(list.getFirst());
		int last = list.getFirst().end;
		for (int i = 1; i < list.size(); i++) {
		// 2. 적절성 검사 - 시간이 겹치지 않는 것 집합에 추가
			if (list.get(i).start > last) {
				last = list.get(i).end;
				result.add(list.get(i));
			}
		}

		for (Task t : result) {
			System.out.print(t.num + " ");
		}
		return answer;
	}
}
