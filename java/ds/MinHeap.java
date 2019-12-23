package ds;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private int size;
	List<Integer> heap;

	public MinHeap() {
		heap = new ArrayList<>();
		heap.add(10000);
	}

	// bottom-up
	private void insert(int n) {
		heap.add(n);
		size++;
		for (int i = size; i > 1; i /= 2) {
			if (heap.get(i / 2) > heap.get(i))
				swap(i / 2, i);
			else
				break;

		}
	}

	// top-down
	private int delete() {
		if (size == 0)
			return 0;
		int item = heap.get(1);
		swap(1, size);
		heap.set(size, 100000000);
		for (int i = 1; i * 2 < size;) {
			if (heap.get(i) < heap.get(i * 2) && heap.get(i) < heap.get(i * 2 + 1)) {
				break;
			} else if (heap.get(i * 2) < heap.get(i * 2 + 1)) {
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

	public void swap(int parent, int child) {
		int temp = heap.get(child);
		heap.set(child, heap.get(parent));
		heap.set(parent, temp);
	}

}
