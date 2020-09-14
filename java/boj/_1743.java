package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1743 {
	/* BOJ - 음식물 피하기 */
	static int n, m, k, answer, count;
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		k = stoi(st.nextToken());

		map = new int[n][m];
		visited = new int[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			map[stoi(st.nextToken()) - 1][stoi(st.nextToken()) - 1] = 1;
		}

		count = 0;
		answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					dfs(new Dot(i, j));
					answer = Math.max(answer, count);
					count = 0;
				}
			}
		}
		System.out.println(answer);
	}

	static void dfs(Dot dot) {
		visited[dot.x][dot.y] = 1;
		count++;
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = dot.x + dx[i];
			ny = dot.y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
				if (visited[nx][ny] == 0 && map[nx][ny] == 1) {
					dfs(new Dot(nx, ny));
				}
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
