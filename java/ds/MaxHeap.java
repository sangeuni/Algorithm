package ds;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
	private int size;
	List<Integer> heap;

	private MaxHeap() {
		heap = new ArrayList<>();
		heap.add(100000); // 첫 번째 index 사용하지 않기 위해서
		size = 0;
	}

	private void insert(int x) {
		heap.add(x); // 끝에 추가
		size++;
		for (int i = size; i > 1; i /= 2) { // Bottom-up
			if (heap.get(i / 2) < heap.get(i)) {
				swap(i / 2, i);
			} else {
				break;
			}
		}

	}

	private int delete() {
		if (size == 0)
			return 0;

		int item = heap.get(1);
		swap(1, size); // root 노드와 힙의 마지막 노드 swap
		heap.set(size, 0);

		for (int i = 1; i * 2 < size;) { // Top-down
			if (heap.get(i) > heap.get(i * 2) && heap.get(i) > heap.get(i * 2 + 1)) { // 현재 노드 값이 자식 노드 보다 크면 break
				break;
			} else if (heap.get(i * 2) > heap.get(i * 2 + 1)) { // 자식 노드(왼,오)중 더 큰 값과 swap
				swap(i, i * 2);
				i = i * 2;
			} else {
				swap(i, i * 2 + 1);
				i = i * 2 + 1;
			}
		}
		heap.remove(size--); // 최대값인 노드를 삭제하고 힙 크기 줄이기
		return item;
	}

	private void swap(int x, int y) {
		int temp = heap.get(x);
		heap.set(x, heap.get(y));
		heap.set(y, temp);
	}

	private void print() {
		for (int i : heap) {
			System.out.print(i + " ");
		}
	}
}
