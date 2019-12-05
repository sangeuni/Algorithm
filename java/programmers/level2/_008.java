package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class _008 {
	/*
	 * Level3 - 네트워크
	 *
	 */
	private int ad[][];
	private int visited[];
	private static int count = 0;

	public int solution(int n, int[][] computers) {
		ad = computers;
		visited = new int[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				bfs(i, n);
			}
		}
		return count;
	}

	private void bfs(int x, int n) {
		count++;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		visited[x] = 1;

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 0; i < n; i++) {
				if (ad[cur][i] == 1 && visited[i] == 0) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}

	}

	public static void main(String[] args) {
		int[][] computers = { { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 0, 1, 1, 0 }, { 1, 1, 0, 1 } };
		System.out.println(new _008().solution(4, computers));
	}
}
