package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2146 {
	/* BOJ - 다리 만들기 */
	static int N, answer;
	static int[][] map, visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Dot {
		private int x;
		private int y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(in.readLine());
		map = new int[N][N];
		visited = new int[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		int num = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] == 0 && map[i][j] == 1) {
					numbering(new Dot(i, j), num++);
				}
			}
		}
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0) {
					init();
					bfs(new Dot(i, j), map[i][j]);
				}
			}
		}
		System.out.println(answer - 2);
	}

	static void bfs(Dot dot, int num) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;

			if (map[cur.x][cur.y] != num && map[cur.x][cur.y] != 0) {
				answer = Math.min(answer, visited[cur.x][cur.y]);
				if (num == 2)
					break;
			}

			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (map[nx][ny] == num || visited[nx][ny] > 0)
					continue;

				q.offer(new Dot(nx, ny));
				visited[nx][ny] = visited[cur.x][cur.y] + 1;
			}
		}
	}

	static void numbering(Dot dot, int num) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			map[cur.x][cur.y] = num;
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;

				if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
					q.offer(new Dot(nx, ny));
					visited[nx][ny] = 1;
				}
			}
		}
	}

	static void init() {
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], 0);
		}
	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------");
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
