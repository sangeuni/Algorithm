package boj;

import java.util.LinkedList;
import java.util.Scanner;

public class _1021 {
	/* 회전하는 큐 */
	LinkedList<Integer> queue;
	int N, M;

	public void go() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		queue = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int count = 0;
		while (M-- > 0) {
			int target = sc.nextInt();
			loop: while (true) {
				int head = queue.indexOf(target);
				int tail = queue.size() - head - 1;
				if (head == 0) {
					queue.remove(head);
					break loop;
				}
				if (head <= tail) {
					queue.addLast(queue.removeFirst());
					count++;
				} else {
					queue.addFirst(queue.removeLast());
					count++;
				}
			}
		}
		System.out.println(count);
	}
}