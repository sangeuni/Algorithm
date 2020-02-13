package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class _17135 {
	/* 
	 * 캐슬디펜스 
	 */
	static int n, m, d, answer;
	static int[][] map, copy, visited;
	static int[] a;
	static int[] dx = { 0, -1, 0 };
	static int[] dy = { -1, 0, 1 };
	static Queue<Node> q;

	static class Node {
		int x, y, step;

		public Node(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		d = stoi(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		answer = Integer.MIN_VALUE;
		a = new int[3];
		permutation(0, 0);
		System.out.println(answer);

	}

	static void permutation(int depth, int start) {
		if (depth == 3) {

			simulation();
			return;
		}

		for (int i = start; i < m; i++) {
			a[depth] = i;
			permutation(depth + 1, i + 1);
		}
	}

	static void simulation() {
		copy();
		int count = 0;
		for (int j = 1; j <= n; j++) {
			for (int i = 0; i < a.length; i++) {
				count += bfs(new Node(n + 1, a[i], 0));
			}

			move();
		}

		answer = Math.max(answer, count);
	}

	static int bfs(Node node) {
		q = new LinkedList<>();
		q.offer(node);
		visited = new int[n + 2][m];
		visited[node.x][node.y] = 1;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 3; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 1 || ny < 0 || nx >= n + 1 || ny >= m)
					continue;

				if (visited[nx][ny] == 1)
					continue;

				if (copy[nx][ny] > 0 && cur.step < d) {
					if (copy[nx][ny] == 1) {
						copy[nx][ny] = 2;
						return 1;
					} else {
						return 0;
					}

				} else if (copy[nx][ny] == 0 && cur.step < d) {
					q.offer(new Node(nx, ny, cur.step + 1));
					visited[nx][ny] = 1;

				}
			}
		}
		return 0;
	}

	static void move() {
		for (int i = n; i > 0; i--) {
			copy[i] = copy[i - 1];
			for (int j = 0; j < m; j++) {
				if (copy[i][j] == 2)
					copy[i][j] = 0;
			}
		}
	}

	static void copy() {
		copy = new int[n + 2][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i + 1][j] = map[i][j];
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
