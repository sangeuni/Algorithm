package boj;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _14226 {
	/* 이모티콘 - bfs */
	int n;
	int[][] d;
	
	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n + 1][n + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i <= n; i++) {
			Arrays.fill(d[i], -1);
		}

		d[1][0] = 0;
		q.add(1);
		q.add(0);

		while (!q.isEmpty()) {
			int s = q.poll();
			int c = q.poll();

			// (s,s)
			if (d[s][s] == -1) {
				d[s][s] = d[s][c] + 1;
				q.add(s);
				q.add(s);
			}
			// (s+c, c)
			if (s + c <= n && d[s + c][c] == -1) {
				d[s + c][c] = d[s][c] + 1;
				q.add(s + c);
				q.add(c);
			}
			// (s-1, c)
			if (s - 1 >= 0 && d[s - 1][c] == -1) {
				d[s - 1][c] = d[s][c] + 1;
				q.add(s - 1);
				q.add(c);
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			if (d[n][i] != -1) {
				ans = Math.min(ans, d[n][i]);
			}
		}
		System.out.println(ans);

	}
}
