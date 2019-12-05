package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11279 {
	/* 최대 힙 */
	int tc;

	class Heap {
		private int size;
		private List<Integer> heap;

		public Heap() {
			size = 0;
			heap = new ArrayList<>();
			heap.add(10000);
		}

		private void insert(int n) {
			heap.add(n);
			size++;
			for (int i = size; i > 1; i /= 2) {
				if (heap.get(i / 2) < heap.get(i)) {
					swap(i / 2, i);
				} else {
					break;
				}
			}
		}

		private int delete() {
			if (size == 0) {
				return 0;
			}
			int item = heap.get(1);
			swap(1, size);
			heap.set(size, 0);

			for (int i = 1; i * 2 < size;) {
				if (heap.get(i) > heap.get(i * 2) && heap.get(i) > heap.get(i * 2 + 1)) {
					break;
				} else if (heap.get(i * 2) > heap.get(i * 2 + 1)) {
					swap(i, i * 2);
					i = i * 2;
				} else {
					swap(i, i * 2 + 1);
					i = i * 2 + 1;
				}
			}
			heap.remove(size--);
			return item;
		}

		private void swap(int x, int y) {
			int temp = heap.get(x);
			heap.set(x, heap.get(y));
			heap.set(y, temp);
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		int num;

		Heap max = new Heap();
		while (tc-- > 0) {
			num = sc.nextInt();
			if (num == 0) {
				System.out.println(max.delete());
			} else {
				max.insert(num);
			}
		}
	}
}
