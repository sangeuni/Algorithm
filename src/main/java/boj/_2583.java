package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2583 {
	// 영역 구하기
	int m, n, k;
	int[][] map;
	int[][] visited;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	List<Integer> list;
	int count = 0;

	private void go() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		k = sc.nextInt();

		map = new int[m][n];
		visited = new int[m][n];
		list = new ArrayList<>();
		int a, b, c, d;
		while (k-- > 0) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			d = sc.nextInt();

			for (int i = b; i < d; i++) {
				for (int j = a; j < c; j++) {
					map[i][j] = 1;
				}
			}
		}

		int countAll = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && visited[i][j] == 0) {
					DFS(i, j);
					countAll++;
					list.add(count);
					count = 0;
				}
			}
		}

		System.out.println(countAll);
		Collections.sort(list);
		for (int i : list) {
			System.out.print(i + " ");
		}

	}

	private void DFS(int v, int c) {
		visited[v][c] = 1;
		count++;
		int nextX, nextY;
		for (int i = 0; i < 4; i++) {
			nextX = v + dx[i];
			nextY = c + dy[i];

			if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
				continue;

			if (map[nextX][nextY] == 1 || visited[nextX][nextY] == 1)
				continue;

			DFS(nextX, nextY);
		}

	}
}
