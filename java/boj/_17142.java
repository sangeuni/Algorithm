package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _17142 {
	/*
	 * 연구소 3
	 */
	static int n, m, min;
	static int[][] map, copy, visited;
	static int[] a;
	static boolean[] c;
	static List<Dot> virusList;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static StringTokenizer st;
	static Deque<Dot> q;

	static class Dot {
		private int x, y, step;

		public Dot(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	public static void main(String[] args) throws IOException {
		input();
		permutation(0, 0);

		min = (min == Integer.MAX_VALUE) ? -1 : min;
		System.out.println(min);
	}

	static void solve() {
		// 바이러스 놓기
		for (int i : a) {
			Dot virus = virusList.get(i);
			copy[virus.x][virus.y] = 0;
			q.offer(virus);
			visited[virus.x][virus.y] = 1;
		}

		int time = bfs();

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] == -1) {
					count++;
				}
			}
		}

		if (count == 0) {
			min = Math.min(min, time);
		}
	}

	static int bfs() {
		int max = 0;
		while (!q.isEmpty()) {
			Dot cur = q.poll();
			max = Math.max(max, copy[cur.x][cur.y]);
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && copy[nx][ny] <= 0) {
					visited[nx][ny] = 1;
					if (copy[nx][ny] == -2) {
						q.offer(new Dot(nx, ny, cur.step + 1));
					}
					if (copy[nx][ny] == -1) {
						copy[nx][ny] = cur.step + 1;
						q.offer(new Dot(nx, ny, cur.step + 1));
					}

				}
			}
		}
//		print(copy);
		return max;
	}

	static void permutation(int count, int start) {
		if (count == m) {
			ready();
			solve();
			return;
		}

		for (int i = start; i < virusList.size(); i++) {
			if (c[i])
				continue;
			a[count] = i;
			c[i] = true;
			permutation(count + 1, i + 1);
			c[i] = false;
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		init();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = stoi(st.nextToken());

				if (map[i][j] == 0) {
					map[i][j] = -1;
				}
				if (map[i][j] == 2) {
					map[i][j] = -2;
					virusList.add(new Dot(i, j, 0));
				}
			}
		}
		c = new boolean[virusList.size()];
	}

	static void ready() {
		q = new LinkedList<>();
		copy = new int[n][n];
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	static void init() {
		map = new int[n][n];
		a = new int[m];

		virusList = new LinkedList<>();
		min = Integer.MAX_VALUE;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}
}
