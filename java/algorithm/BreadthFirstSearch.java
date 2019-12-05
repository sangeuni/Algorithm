package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
	int adjacent[][];
	boolean visited[];
	int vertice, edge, start;

	private void go() {
		Scanner scanner = new Scanner(System.in);
		vertice = scanner.nextInt();
		edge = scanner.nextInt();
		start = scanner.nextInt();

		adjacent = new int[vertice + 1][vertice + 1];
		visited = new boolean[vertice + 1];
		int a, b;
		for (int i = 0; i < edge; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			adjacent[a][b] = adjacent[b][a] = 1;
		}

		bfs(start);
	}

	private void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.offer(start);
		System.out.print(start + " ");
		int temp;
		while (!queue.isEmpty()) {
			temp = queue.poll();
			for (int i = 0; i <= vertice; i++) {
				if (adjacent[temp][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
					System.out.print(i + " ");
				}
			}
		}
	}
}
