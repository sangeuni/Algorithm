package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _14502 {
	/* 연구소 */

	int N, M;
	int[][] map, copy;
	int[][] visited;
	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };
	int[] wall;
	ArrayList<Dot> virus;
	ArrayList<Dot> safetyArea;
	int max = Integer.MIN_VALUE;

	class Dot {
		private int x, y;

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
		wall = new int[3];

		virus = new ArrayList<>();
		safetyArea = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					safetyArea.add(new Dot(i, j));
				}
				if (map[i][j] == 2) {
					virus.add(new Dot(i, j));
				}
			}
		}

		combination(wall, safetyArea.size(), 3, 0, 0);

		System.out.println(max);

	}

	public void combination(int[] wall, int n, int r, int index, int target) {
		if (r == 0) {
			copy = new int[N][M];
			init();
			for (int i = 0; i < 3; i++) {
				Dot dot = safetyArea.get(wall[i]);
				copy[dot.x][dot.y] = 1;
			}

			for (int i = 0; i < virus.size(); i++) {
				dfs(virus.get(i));
			}

			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 0)
						count++;
				}
			}

			if (max < count)
				max = count;
			return;
		} else if (n == target) {
			return;
		}
		wall[index] = target;
		combination(wall, n, r - 1, index + 1, target + 1);
		combination(wall, n, r, index, target + 1);

	}

	public void dfs(Dot dot) {

		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = dot.x + dx[i];
			ny = dot.y + dy[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;

			if (copy[nx][ny] == 0) {
				copy[nx][ny] = 2;
				dfs(new Dot(nx, ny));
			}
		}
	}

	public void bfs(Dot dot) {
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

				if (copy[nx][ny] == 1 || visited[nx][ny] == 1)
					continue;

				copy[nx][ny] = 2;

				visited[nx][ny] = 1;
				q.offer(new Dot(nx, ny));
			}
		}
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
