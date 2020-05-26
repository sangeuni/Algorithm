package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3184 {
	/* 양 */
	static int r, c, v, o;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Queue<Dot> q;

	static class Dot {
		private int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		init();
		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (visited[i][j] == 0 && map[i][j] != '#') {
					bfs(new Dot(i, j));
				}
			}
		}

		System.out.println(o + " " + v);
	}

	public static void bfs(Dot dot) {
		int vCnt = 0;
		int oCnt = 0;
		q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();

			if (map[cur.x][cur.y] == 'o')
				oCnt++;
			if (map[cur.x][cur.y] == 'v')
				vCnt++;

			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c)
					continue;
				if (map[nx][ny] == '#' || visited[nx][ny] == 1)
					continue;

				q.offer(new Dot(nx, ny));
				visited[nx][ny] = 1;
			}

		}
		if (vCnt > 0 && vCnt >= oCnt) {
			v += vCnt;
		} else if (oCnt > 0 && vCnt < oCnt) {
			o += oCnt;
		}
	}

	public static void init() {
		map = new char[r][c];
		visited = new int[r][c];
	}

	public static int stoi(String s) {
		return Integer.valueOf(s);
	}

	public static void print(char[][] c) {
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
	}
}
