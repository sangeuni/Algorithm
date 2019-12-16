package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5014 {
	/* 스타트링크 */
	int F, S, G, U, D;
	int[] elevator;

	public void go() {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		elevator = new int[F + 1];

		System.out.println(bfs(S));
	}

	public String bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		elevator[start] = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur == G)
				return Integer.toString(elevator[cur] - 1);
			
			if (cur + U <= F && elevator[cur + U] == 0) {
				q.offer(cur + U);
				elevator[cur + U] = elevator[cur] + 1;
			}

			if (cur - D > 0 && elevator[cur - D] == 0) {
				q.offer(cur - D);
				elevator[cur - D] = elevator[cur] + 1;
			}
		}

		return "use the stairs";
	}
}
