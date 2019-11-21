package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2644 {
	/* 촌수계산 */
	int[][] map;
	int[] visited;
	int n, m, p1, p2;
	int count;
	int[] d;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		p1 = sc.nextInt();
		p2 = sc.nextInt();
		m = sc.nextInt();
		d = new int[n + 1];
		map = new int[n + 1][n + 1];
		visited = new int[n + 1];
		int a, b;
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			map[a][b] = map[b][a] = 1;
		}

		dfs(p1);
		// bfs(p1);
		System.out.println(d[p2] == 0 ? -1 : d[p2]);
	}

	public void bfs(int p) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(p);
		visited[p] = 1;
		d[p] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= n; i++) {
				if (map[cur][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = 1;
					d[i] = d[cur] + 1;
				}
			}
		}
	}

	public void dfs(int p) {
		visited[p] = 1;

		for (int i = 1; i <= n; i++) {
			if (map[p][i] == 1 && visited[i] == 0) {
				d[i] = d[p] + 1;
				dfs(i);
			}
		}
	}
}
