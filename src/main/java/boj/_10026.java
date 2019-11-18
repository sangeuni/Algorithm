package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _10026 {
	int map1[][];
	int map2[][];
	int visited[][];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };
	int c1 = 0;
	int c2 = 0;
	int n;

	class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.nextLine();
		map1 = new int[n][n];
		map2 = new int[n][n];
		visited = new int[n][n];
		String s;
		for (int i = 0; i < n; i++) {
			s = sc.nextLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == 'R') {
					map1[i][j] = 0;
					map2[i][j] = 0;
					continue;
				}
				if (s.charAt(j) == 'G') {
					map1[i][j] = 1;
					map2[i][j] = 0;
					continue;
				}
				if (s.charAt(j) == 'B') {
					map1[i][j] = 2;
					map2[i][j] = 2;
					continue;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					bfs(i, j, map1);
					c1++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], 0);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 0) {
					bfs(i, j, map2);
					c2++;
				}
			}
		}

		System.out.println(c1 + " " + c2);

	}

	public void bfs(int x, int y, int[][] map) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(new Dot(x, y));
		visited[x][y] = 1;
		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx >= n || ny >= n || nx < 0 || ny < 0)
					continue;
				if (map[cur.x][cur.y] != map[nx][ny] || visited[nx][ny] == 1)
					continue;

				q.offer(new Dot(nx, ny));
				visited[nx][ny] = 1;
			}
		}
	}
}
