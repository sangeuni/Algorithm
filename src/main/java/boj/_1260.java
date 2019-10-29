package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1260 {
	// BFS와 DFS
	int[][] ad;
	boolean[] visited;
	int n, m, k;

	private void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();

		ad = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		int a, b;
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			ad[a][b] = ad[b][a] = 1;
		}

		DFS(k);
		initialize();
		BFS(k);
	}

	private void DFS(int start) {
		// TODO Auto-generated method stub
		visited[start] = true;
		System.out.print(start + " ");

		for (int i = 0; i <= n; i++) {
			if (ad[start][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}
	}

	private void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		System.out.print(start + " ");
		int temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			for (int i = 0; i <= n; i++) {
				if (ad[temp][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
					System.out.print(i + " ");
				}
			}
		}
	}
	
	private void initialize() {
		System.out.println();
		for(int i = 0; i<=n; i++) {
			visited[i] = false;
		}
	}
}
