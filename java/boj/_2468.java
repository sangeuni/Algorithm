package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _2468 {
	/* 안전영역 */
	int[][] copy;
	int[][] map;
	int[][] visited;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	int N;
	List<Integer> list;

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
		map = new int[N][N];
		visited = new int[N][N];
		list = new LinkedList<>();
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (max < map[i][j])
					max = map[i][j];
			}
		}
		int answer = 1;
		while (max > 0) {
			copy = new int[N][N];
			init();
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i][j] == 0 && copy[i][j] > max) {
						bfs(new Dot(i, j), max);
						count++;
					}
				}
			}
			answer = Math.max(count, answer);
			max--;
		}
		System.out.println(answer);
	}

	public void bfs(Dot dot, int max) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (visited[nx][ny] == 1 || copy[nx][ny] <= max)
					continue;

				q.offer(new Dot(nx, ny));
				visited[nx][ny] = 1;

			}
		}

	}

	public void init() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], 0);
		}
	}
}
