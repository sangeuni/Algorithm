package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _17070 {
	/* BOJ - 파이프 옮기기 1 */
	static final int WIDTH = 0;
	static final int HEIGHT = 1;
	static final int DIAGONAL = 2;
	static int n, answer;
	static int[][] map, visited;
	static int[] dx = { 0, 1, 1 };
	static int[] dy = { 1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		answer = 0;
		dfs(WIDTH, 0, 1);
		System.out.println(answer);
	}

	static void dfs(int pipe, int x, int y) {
		if (x == n - 1 && y == n - 1) {
			answer++;
			visited[x][y] = 0;
			return;
		}

		visited[x][y] = 1;

		int nx, ny;
		// 가로
		if (pipe == WIDTH) {
			for (int i : new int[] { WIDTH, DIAGONAL }) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && check(i, x, y)) {
					dfs(i, nx, ny);
					visited[nx][ny] = 0;
				}
			}
		} // 세로
		else if (pipe == HEIGHT) {
			for (int i : new int[] { HEIGHT, DIAGONAL }) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && check(i, x, y)) {
					dfs(i, nx, ny);
					visited[nx][ny] = 0;
				}
			}
		} // 대각선
		else {
			for (int i : new int[] { WIDTH, HEIGHT, DIAGONAL }) {
				nx = x + dx[i];
				ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == 0 && check(i, x, y)) {
					dfs(i, nx, ny);
					visited[nx][ny] = 0;
				}
			}
		}
	}

	static boolean check(int pipe, int x, int y) {
		if (pipe == WIDTH) {
			if (map[x + dx[WIDTH]][y + dy[WIDTH]] == 0) {
				return true;
			}
		} else if (pipe == HEIGHT) {
			if (map[x + dx[HEIGHT]][y + dy[HEIGHT]] == 0) {
				return true;
			}
		} else {
			if (map[x + dx[WIDTH]][y + dy[WIDTH]] == 0 && map[x + dx[HEIGHT]][y + dy[HEIGHT]] == 0
					&& map[x + dx[DIAGONAL]][y + dy[DIAGONAL]] == 0) {
				return true;
			}
		}
		return false;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
