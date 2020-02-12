package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _3055 {
	/* 탈출
	 * - bfs
	 * - 조건 처리 어렵다 ..  
	 */
	int n, m;
	int[][] map;
	int[][] visited;
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };
	Queue<Dot> q;

	class Dot {
		private int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		sc.nextLine();
		String str;
		Dot s = null;
		Dot d = null;
		q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			for (int j = 0; j < m; j++) {
				char temp = str.charAt(j);
				if (temp == '.')
					map[i][j] = 100;
				if (temp == 'X')
					map[i][j] = Integer.MIN_VALUE;
				if (temp == '*') {
					map[i][j] = 0;
					q.offer(new Dot(i, j));
					visited[i][j] = 1;
				}
				if (temp == 'S') {
					map[i][j] = Integer.MAX_VALUE; // 물 이동 x
					s = new Dot(i, j);
				}
				if (temp == 'D') {
					map[i][j] = Integer.MAX_VALUE; // 물 이동 x
					d = new Dot(i, j);
				}
			}
		}
		// 물 채우기
		bfs();
		init();
		bfs(s);

		if (map[d.x][d.y] != Integer.MAX_VALUE) {
			System.out.println(map[d.x][d.y]);
		} else {
			System.out.println("KAKTUS");
		}
	}

	public void init() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(visited[i], 0);
		}
		q.clear();
	}

	public void bfs() {
		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				// 빈 칸만 이동 가능
				if (map[nx][ny] == 100 && visited[nx][ny] == 0) {
					map[nx][ny] = map[cur.x][cur.y] + 1;
					q.offer(new Dot(nx, ny));
					visited[nx][ny] = 1;
				}
			}
		}
	}

	public void bfs(Dot dot) {
		q.offer(dot);
		visited[dot.x][dot.y] = 1;
		map[dot.x][dot.y] = 0;
		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int x = cur.x;
			int y = cur.y;

			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[cur.x][cur.y] + 1 >= map[nx][ny] || visited[nx][ny] == 1)
					continue;

				map[nx][ny] = map[cur.x][cur.y] + 1;
				q.offer(new Dot(nx, ny));
				visited[nx][ny] = 1;

			}
		}
	}
}
