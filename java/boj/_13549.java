package boj;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _13549 {
	/* 숨바꼭질 3 - deque */
	public static final int MAX = 100001;
	int n, k;
	boolean[] c;
	int[] d;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		d = new int[MAX];
		c = new boolean[MAX];

		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.offer(n);
		d[n] = 0;
		c[n] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : new int[] { cur * 2, cur - 1, cur + 1 }) {
				if (next >= 0 && next < MAX) {
					if (!c[next]) {
						c[next] = true;
						if (next == cur * 2) {
							q.offerFirst(next);
							d[next] = d[cur];
						} else {
							q.offerLast(next);
							d[next] = d[cur] + 1;
						}
					}
				}
			}
		}

		System.out.println(d[k]);
	}
}
