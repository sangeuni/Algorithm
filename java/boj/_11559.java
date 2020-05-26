package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _11559 {
	/* Puyo Puyo */
	static int answer;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Dot> q;
	static List<Dot> puyoList;

	static class Dot {
		private int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init();
		for (int i = 0; i < 12; i++) {
			String line = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		boolean flag;
		while (true) {
			flag = false;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (map[i][j] != '.') {
						ready();
						if (bfs(new Dot(i, j), map[i][j])) {
							flag = true;
						}
					}
				}
			}
			down();
			if (!flag)
				break;
			else
				answer++;
		}
		System.out.println(answer);
	}

	public static boolean bfs(Dot dot, char puyo) {
		puyoList = new LinkedList<>();
		q = new LinkedList<>();
		puyoList.add(dot);
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		int count = 1;
		while (!q.isEmpty()) {
			Dot cur = q.poll();

			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6)
					continue;
				if (map[nx][ny] == '.' || visited[nx][ny] == 1)
					continue;

				if (map[nx][ny] == puyo) {
					puyoList.add(new Dot(nx, ny));
					q.offer(new Dot(nx, ny));
					visited[nx][ny] = 1;
					count++;
				}
			}
		}
		if (count >= 4) {
			for (Dot d : puyoList) {
				map[d.x][d.y] = '.';
			}
			return true;
		}
		return false;
	}

	public static void down() {
		for (int i = 0; i < 6; i++) {
			for (int j = 10; j >= 0; j--) {
				char ch = map[j][i];
				if (ch == '.')
					continue;
				int row = j;
				while (row <= 10) {
					if (map[row + 1][i] == '.') {
						map[row + 1][i] = ch;
						map[row][i] = '.';
					}
					row++;
				}
			}
		}
	}

	public static void ready() {
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], 0);
		}
	}

	public static void init() {
		answer = 0;
		map = new char[12][6];
		visited = new int[12][6];
	}
}
