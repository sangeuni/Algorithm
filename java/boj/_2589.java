package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2589 {
	/* 보물섬 */
	int[][] map;
	int[][] copy;
	int[][] visited;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int N, M;

	class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		visited = new int[N][M];
		sc.nextLine();
		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W')
					map[i][j] = 0; // 바다
				if (str.charAt(j) == 'L')
					map[i][j] = 1; // 육지
			}
		}
		int max = Integer.MIN_VALUE, result;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy = new int[N][M];
				init();
				if (visited[i][j] == 0 && map[i][j] == 1) {
					result = bfs(new Dot(i, j));
					if (max < result)
						max = result;
				}
			}
		}
		System.out.println(max);
	}

	public int bfs(Dot dot) {
		int count = 0;
		Queue<Dot> q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (visited[nx][ny] == 1 || copy[nx][ny] == 0)
					continue;

				q.offer(new Dot(nx, ny));
				visited[nx][ny] = 1;
				copy[nx][ny] = copy[cur.x][cur.y] + 1;
				count = copy[nx][ny] - 1;
			}
		}
		return count;
	}

	public void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], 0);
		}
	}
}
