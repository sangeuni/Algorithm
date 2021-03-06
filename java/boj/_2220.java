package boj;

import java.util.Scanner;

public class _2220 {
	/*
	 * boj - 힙 정렬
	 * 힙 삭제 연산에 대한 이해를 바탕으로 풀어야 하는 문제
	 * 
	 */
	int[] arr;

	public void go() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		arr = new int[num + 1];
		arr[1] = 1;
		for (int i = 2; i <= num; i++) {
			arr[i] = i;
			int j = i - 1;
			swap(i, j);	// 1을 끝에 위치하기 위한 swap
			while (j != 1) {
				swap(j, j / 2);	// arr[j] 에 가장 큰 수가 위치하는 상태이기 때문에 최대힙을 구성하기 위한 swap
				j /= 2;	// 
			}
		}
		print();
	}

	public void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void print() {
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
