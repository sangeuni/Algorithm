package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _1389 {
	/* 케빈 베이컨의 6단계 법칙 */
	int[][] map;
	int[] visited;
	int[][] d;
	int n, m;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		visited = new int[n + 1];
		d = new int[n + 1][n + 1];
		int a, b;
		for (int i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();

			map[a][b] = map[b][a] = 1;
		}

		for (int i = 1; i <= n; i++) {
			bfs(i);
			Arrays.fill(visited, 0);
		}
		
		List<Integer> list = new LinkedList<>();
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum += d[i][j];
			}
			list.add(sum);
			sum = 0;
		}
		int min = 0;
		int answer;
		for(int i = 1; i<list.size(); i++) {
			if(list.get(min) > list.get(i)) {
				min = i;
			}else if(list.get(min) == list.get(i)) {
				continue;
			}
		}
		
		System.out.println(min+1);
	}

	public void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		visited[x] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int i = 1; i <= n; i++) {
				if (map[cur][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
					d[x][i] = d[x][cur] + 1;
				}
			}
		}
	}
}
