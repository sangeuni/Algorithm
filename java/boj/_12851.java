package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _12851 {
	/*
	 * 숨바꼭질 2 - BFS, DP
	 */
	public static final int MAX = 100001;
	int n, k;
	int[] dist, cnt;
	boolean c[];
	int min = Integer.MAX_VALUE;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		dist = new int[MAX];
		cnt = new int[MAX];
		c = new boolean[MAX];
		cnt[n] = 1;
		bfs(n);
		System.out.println(dist[k]);
		System.out.println(cnt[k]);
	}

	public void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		dist[n] = 0;
		c[n] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : new int[] { cur * 2, cur + 1, cur - 1 }) {
				if (next >= 0 && next < MAX) {
					if (!c[next]) {
						dist[next] = dist[cur] + 1;
						cnt[next] = cnt[cur];
						c[next] = true;
						q.offer(next);
					} else if (dist[next] == dist[cur] + 1) {
						cnt[next] += cnt[cur];
					}
				}
			}
		}
	}
}
