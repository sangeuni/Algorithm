package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7562 {
	int[][] map;
	int[][] visited;
	int[] dx = { -1, -2, -2, -1, 1, 2, 1, 2 };
	int[] dy = { -2, -1, 1, 2, -2, -1, 2, 1 };
	int n;

	class Dot {
		private int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			n = sc.nextInt();
			map = new int[n][n];
			visited = new int[n][n];
			int sx = sc.nextInt();
			int sy = sc.nextInt();
			int ex = sc.nextInt();
			int ey = sc.nextInt();

			bfs(sx, sy);

			System.out.println(map[ex][ey]);
		}
		
		sc.close();
	}

	private void bfs(int x, int y) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(x, y));
		visited[x][y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nextX, nextY;
			for (int i = 0; i < dx.length; i++) {
				nextX = cur.x + dx[i];
				nextY = cur.y + dy[i];

				if (nextX >= n || nextY >= n || nextX < 0 || nextY < 0)
					continue;
				if (visited[nextX][nextY] == 1)
					continue;
				map[nextX][nextY] = map[cur.x][cur.y] + 1;
				q.offer(new Dot(nextX, nextY));
				visited[nextX][nextY] = 1;
			}
		}
	}
}
