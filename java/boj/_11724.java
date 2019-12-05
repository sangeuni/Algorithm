package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11724 {
	int[][] ad;
	int[] visited;
	int v, e;
	int count = 0;

	private void go() {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();

		ad = new int[v + 1][v + 1];
		visited = new int[v + 1];

		int a, b;
		for (int i = 0; i < e; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			ad[a][b] = ad[b][a] = 1;
		}

		for (int i = 1; i <= v; i++) {
			if (visited[i] == 0) {
				DFS(i);
				count++;
			}
		}

		System.out.print(count);
	}

	private void BFS(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(n);
		visited[n] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 1; i <= v; i++) {
				if (ad[cur][i] == 1 && visited[i] == 0) {
					queue.offer(i);
					visited[i] = 1;
				}
			}
		}
		count++;
	}

	private void DFS(int n) {
		visited[n] = 1;
		for (int i = 1; i <= v; i++) {
			if (ad[n][i] == 1 && visited[i] == 0) {
				DFS(i);
			}
		}
	}
}
