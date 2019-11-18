package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _9372 {
	int n, m;
	int[] visited;

	public void go() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();

			int[][] map = new int[n + 1][n + 1];
			visited = new int[n + 1];

			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				map[a][b] = map[b][a] = 1;
			}

			System.out.println(bfs(1, map));
		}
	}

	public int bfs(int x, int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = 1;
		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= n; i++) {
				if (map[cur][i] == 1 && visited[i] == 0) {
					count++;
					q.offer(i);
					visited[i] = 1;
				}
			}
		}

		return count;
	}
}
