package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _5853 {
	/* 프린터 큐 */
	int N, M;
	Queue<Document> printerQ;

	class Document {
		int value;
		boolean target;

		public Document(int value, boolean target) {
			this.value = value;
			this.target = target;
		}

		// 알고 싶은 문서인지
		private boolean isTarget() {
			return this.target;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		while (tc-- > 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			printerQ = new LinkedList<>();

			// input
			for (int i = 0; i < N; i++) {
				int value = sc.nextInt();
				if (i == M) {
					printerQ.add(new Document(value, true));
				} else {
					printerQ.add(new Document(value, false));
				}
			}

			System.out.println(print());
		}
	}

	public int print() {
		int count = 0;
		while (true) {
			Document cur = printerQ.poll();
			// 나머지 문서 중 중요도가 높은 문서가 없는지
			if (isVaild(cur)) {
				// 인쇄
				count++;
				// 알고 싶은 문서라면 순서 리턴
				if (cur.isTarget())
					return count;
			} else {
				// 다시 재배치
				printerQ.offer(cur);
			}

		}
	}

	public boolean isVaild(Document cur) {
		int value = cur.value;
		for (Document d : printerQ) {
			if (value < d.value)
				return false;
		}
		return true;
	}
}
