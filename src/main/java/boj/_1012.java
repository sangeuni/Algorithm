package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1012 {
	int[][] ad;
	boolean[][] visited;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int m, n, k;
	static int count;

	private void go() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			count = 0;
			m = sc.nextInt();
			n = sc.nextInt();
			k = sc.nextInt();

			ad = new int[m][n];
			visited = new boolean[m][n];
			int a, b;
			for (int i = 0; i < k; i++) {
				a = sc.nextInt();
				b = sc.nextInt();

				ad[a][b] = 1;
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (ad[i][j] != 0 && !visited[i][j]) {
						BFS(i, j);
					}
				}
			}
			System.out.println(count);
		}
	}

	private void BFS(int x, int y) {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(x, y));
		visited[x][y] = true;

		int nextX = 0, nextY = 0;
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dx[i];
				nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
					continue;

				if (ad[nextX][nextY] == 0 || visited[nextX][nextY])
					continue;

				queue.add(new Dot(nextX, nextY));
				visited[nextX][nextY] = true;
			}
		}
		count++;
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
