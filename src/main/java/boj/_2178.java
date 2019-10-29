package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2178 {
	int ad[][];
	boolean visited[][];
	int n, m;
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };

	private void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		ad = new int[n][m];
		visited = new boolean[n][m];
		String str;
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				ad[i][j] = str.charAt(j) - '0';
			}
		}

		BFS(0, 0);
		System.out.print(ad[n - 1][m - 1]);

		sc.close();
	}

	private void BFS(int x, int y) {
		Queue<Dot> queue = new LinkedList<>();
		queue.offer(new Dot(x, y));
		visited[x][y] = true;

		int nextX, nextY;
		while (!queue.isEmpty()) {
			Dot cur = queue.poll();
			for (int i = 0; i < 4; i++) {
				nextX = cur.x + dx[i];
				nextY = cur.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;

				if (ad[nextX][nextY] == 0 || visited[nextX][nextY])
					continue;

				queue.offer(new Dot(nextX, nextY));
				visited[nextX][nextY] = true;
				ad[nextX][nextY] = ad[cur.x][cur.y] + 1;
			}
		}
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
