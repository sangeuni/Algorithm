package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _14503 {
	/*
	 * 로봇 청소기 
	 * - 시뮬레이션 
	 * - SW 역량 테스트 기출문제
	 */
	int[][] map;
	int[][] visited;
	// 0(북), 1(동), 2(남), 3(서)
	int[] dx = { -1, 0, 1, 0 };
	int[] dy = { 0, 1, 0, -1 };
	int answer = 0;
	int n, m;

	class Robot {
		int x, y, d;

		public Robot(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		int r, c, d;
		r = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Robot robot = new Robot(r, c, d);
		start(robot);
		System.out.println(answer + 1);
	}

	public void start(Robot robot) {
		Queue<Robot> q = new LinkedList<>();
		q.offer(robot);
		visited[robot.x][robot.y] = 1;

		while (!q.isEmpty()) {
			Robot cur = q.poll();
			int base = cur.d;
			int nx, ny;
			boolean flag = false;

			loop: for (int i = 0; i < 4; i++) {
				base = nextDirection(base);
				nx = cur.x + dx[base];
				ny = cur.y + dy[base];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0 && visited[nx][ny] == 0) {
						flag = true;
						q.offer(new Robot(nx, ny, base));
						visited[nx][ny] = 1;
						answer++;
						break loop;
					}
				}
			}

			if (!flag) {
				base = backDirection(cur.d);
				nx = cur.x + dx[base];
				ny = cur.y + dy[base];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if (map[nx][ny] == 0) {
						q.offer(new Robot(nx, ny, cur.d));
					}
				}

			}
		}

	}

	public int nextDirection(int i) {
		if (i == 0) {
			return 3;
		} else if (i == 1) {
			return 0;
		} else if (i == 2) {
			return 1;
		} else {
			return 2;
		}
	}

	public int backDirection(int i) {
		if (i == 0) {
			return 2;
		} else if (i == 1) {
			return 3;
		} else if (i == 2) {
			return 0;
		} else {
			return 1;
		}
	}
}
