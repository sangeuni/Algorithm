package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697 {
	/* 숨바꼭질 - bfs */
	int n, k;
	int[] d;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		d = new int[100001];
		d[n] = 1;
		bfs(n);
		System.out.println(d[k] - 1);
	}

	public void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);

		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur - 1 >= 0 && cur - 1 < d.length) {
				if (d[cur - 1] == 0) {
					d[cur - 1] = d[cur] + 1;
					q.offer(cur - 1);
				}
			}

			if (cur + 1 >= 0 && cur + 1 < d.length) {
				if (d[cur + 1] == 0) {
					d[cur + 1] = d[cur] + 1;
					q.offer(cur + 1);
				}

			}
			if (cur * 2 >= 0 && cur * 2 < d.length) {
				if (d[cur * 2] == 0) {
					d[cur * 2] = d[cur] + 1;
					q.offer(cur * 2);
				}
			}
		}
	}
}
