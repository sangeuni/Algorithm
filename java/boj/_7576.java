package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7576 {
	// 토마토
	int[][] map;
	int[][] visited;
	int n, m;
	Queue<Dot> q;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };

	private void go() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt(); // 6
		n = sc.nextInt(); // 4
		map = new int[n][m];
		visited = new int[n][m];
		q = new LinkedList<>();
		int temp;
		for (int i = 0; i < n; i++) { // 세로
			for (int j = 0; j < m; j++) { // 가로
				temp = sc.nextInt();
				map[i][j] = temp;

				if (temp == 1) {
					q.offer(new Dot(i, j));
					visited[i][j] = 1;
				}
			}
		}

		BFS();

		int day = 1;
		forout: for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					day = 0;
					break forout;
				}
				if (map[i][j] >= day) {
					day = map[i][j];
				}
			}
		}

		System.out.println(day - 1);
	}

	private void BFS() {
		Dot cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			int nextX, nextY;
			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dx[i]; // 1 -1 0 0
				nextY = cur.y + dy[i]; // 0 0 1 -1

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;

				if (map[nextX][nextY] == -1 || visited[nextX][nextY] == 1)
					continue;

				map[nextX][nextY] = map[cur.x][cur.y] + 1;
				q.offer(new Dot(nextX, nextY));
				visited[nextX][nextY] = 1;
			}

		}
	}

	class Dot {
		int x;
		int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
