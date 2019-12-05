package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _11403 {
	int[][] ad;
	int[][] answer;
	int[] visited;
	int n, m, k;
	int src;

	private void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		ad = new int[n][n];
		answer = new int[n][n];
		visited = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ad[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			src = i;
			Arrays.fill(visited, 0);
			BFS(i);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	private void DFS(int v) {
		for (int i = 0; i < n; i++) {
			if (ad[v][i] == 1 && visited[i] == 0) {
				visited[i] = 1;
				answer[src][i] = 1;
				DFS(i);
			}
		}
	}

	private void BFS(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i = 0; i < n; i++) {
				if (ad[cur][i] == 1 && visited[i] == 0) {
					answer[src][i] = 1;
					visited[i] = 1;
					queue.offer(i);
				}
			}
		}
	}
}
