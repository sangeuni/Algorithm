package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2206 {
	/*
	 * 벽 부수고 이동하기 - bfs - 정점에서 할 수 있는 선택이 달라지면 다른 정점으로 판단한다(T/F).
	 */
	int n, m;
	int[][] map;
	int[][][] visited;
	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };

	class Dot {
		private int x, y, z;

		public Dot(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		map = new int[n][m];
		visited = new int[n][m][2];
		sc.nextLine();
		String s;
		for (int i = 0; i < n; i++) {
			s = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs(new Dot(0, 0, 0));

		// 벽 거치고 도착, 벽 안 거치고 도착
		if (visited[n - 1][m - 1][0] != 0 && visited[n - 1][m - 1][1] != 0) {
			System.out.println(Math.min(visited[n - 1][m - 1][0], visited[n - 1][m - 1][1]));
		} // 벽 거친 경우만 도착
		else if (visited[n - 1][m - 1][1] != 0) {
			System.out.println(visited[n - 1][m - 1][1]);
		} // 벽 안 거친 경우만 도착
		else if (visited[n - 1][m - 1][0] != 0) {
			System.out.println(visited[n - 1][m - 1][0]);
		} else {
			System.out.println(-1);
		}
	}

	public void bfs(Dot dot) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y][dot.z] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int x = cur.x;
			int y = cur.y;
			int z = cur.z;
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				// 빈칸인 경우
				if (map[nx][ny] == 0 && visited[nx][ny][z] == 0) {
					visited[nx][ny][z] = visited[x][y][z] + 1;
					q.offer(new Dot(nx, ny, z));
					// 벽인 경우
				} else if (z == 0 && map[nx][ny] == 1 && visited[nx][ny][z + 1] == 0) {
					visited[nx][ny][z + 1] = visited[x][y][z] + 1;
					q.offer(new Dot(nx, ny, z + 1));
				}
			}
		}
	}
}
