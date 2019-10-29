package boj;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _2667 {
	// 단지 번호 붙이기
	int[][] ad;
	boolean[][] visited;
	int n;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	List<Integer> list;
	int count, countAll = 0;

	private void go() {
		Scanner scanner = new Scanner(System.in);
		list = new LinkedList<>();
		n = scanner.nextInt();
		scanner.nextLine();
		ad = new int[n][n];
		visited = new boolean[n][n];
		String str;
		for (int i = 0; i < n; i++) {
			str = scanner.nextLine();
			for (int j = 0; j < n; j++) {
				ad[i][j] = str.charAt(j) - '0';
			}
		}

		// DFS
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ad[i][j] == 1 && !visited[i][j]) {
					DFS(i, j);
					countAll++;
					list.add(count);
					count = 0;

				}
			}
		}

		// BFS
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ad[i][j] != 0 && !visited[i][j]) {
					BFS(i, j);
				}
			}
		}

		System.out.println(list.size());
		Collections.sort(list);
		for (int n : list)
			System.out.println(n);

		scanner.close();
	}

	private void DFS(int x, int y) {
		visited[x][y] = true;
		count++;

		Dot cur = new Dot(x, y);
		int nextX, nextY;
		for (int i = 0; i < 4; i++) {
			nextX = dx[i] + cur.x;
			nextY = dy[i] + cur.y;
			if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
				continue;
			if (ad[nextX][nextY] == 0 || visited[nextX][nextY])
				continue;
			DFS(nextX, nextY);
		}
	}

	private void BFS(int x, int y) {
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(x, y));
		visited[x][y] = true;

		int nextX, nextY;
		count = 0;
		while (!queue.isEmpty()) {
			count++;
			Dot cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dx[i];
				nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
					continue;

				if (ad[nextX][nextY] == 0 || visited[nextX][nextY])
					continue;

				queue.offer(new Dot(nextX, nextY));
				visited[nextX][nextY] = true;
			}
		}
		list.add(count);
	}

	class Dot {
		private int x;
		private int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
