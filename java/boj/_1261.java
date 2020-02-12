package boj;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class _1261 {
	/* 알고스팟 - bfs */
	int n, m;
	int[][] map;
	int[][] d;
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };

	class Dot {
		private int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();

		map = new int[n][m];
		d = new int[n][m];
		sc.nextLine();
		String s;
		for (int i = 0; i < n; i++) {
			s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(d[i], -1);
		}

		bfs(0, 0);
	}

	public void bfs(int x, int y) {
		Deque<Dot> q = new LinkedList<>();
		q.offer(new Dot(x, y));
		d[x][y] = 0;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (d[nx][ny] == -1) {
						if (map[nx][ny] == 0) {
							d[nx][ny] = d[cur.x][cur.y];
							q.offerFirst(new Dot(nx, ny));
						} else {
							d[nx][ny] = d[cur.x][cur.y]+1;
							q.offerLast(new Dot(nx, ny));
						}
					}
				}
			}
		}
		System.out.println(d[n - 1][m - 1]);
	}
}
