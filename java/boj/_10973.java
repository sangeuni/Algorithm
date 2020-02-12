package boj;

import java.util.Scanner;

public class _10973 {
	/* 이전 수열 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];

		// 기준이 되는 수열 입력
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		if (prev_permutation(a, n)) {
			for (int i : a)
				System.out.print(i + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}

	}

	private boolean prev_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] <= a[i])
			i -= 1;
		if (i <= 0)
			return false;
		int j = n - 1;
		while (a[i - 1] <= a[j])
			j -= 1;
		swap(a, i - 1, j);
		j = n - 1;
		while (i < j) {
			swap(a, i, j);
			i += 1;
			j -= 1;
		}
		return true;
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
