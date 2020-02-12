package boj;

import java.util.Scanner;

public class _14888 {
	/* 연산자 끼워넣기 : BF(Permutation, Combination) */
	int n;
	int[] a, op;
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;

	public void go_combination() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		a = new int[n];
		op = new int[4];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			op[i] = sc.nextInt();
		}

		combination(1, op[0], op[1], op[2], op[3], a[0]);
		System.out.println(max);
		System.out.println(min);
	}

	public void combination(int idx, int p, int s, int m, int d, int sum) {
		if (idx == n) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		if (p > 0)
			combination(idx + 1, p - 1, s, m, d, sum + a[idx]);
		if (s > 0)
			combination(idx + 1, p, s - 1, m, d, sum - a[idx]);
		if (m > 0)
			combination(idx + 1, p, s, m - 1, d, sum * a[idx]);
		if (d > 0)
			combination(idx + 1, p, s, m, d - 1, sum / a[idx]);

	}

	public void go_permutation() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] numbers = new int[n];
		int[] a = new int[n - 1];
		// input : numbers
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		// input : operator
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int op = sc.nextInt();
			for (int j = 0; j < op; j++) {
				a[idx++] = i;
			}
		}
		long min = Integer.MAX_VALUE;
		long max = Integer.MIN_VALUE;
		do {
			long sum = numbers[0];
			for (int i = 0; i < n - 1; i++) {
				if (a[i] == 0) {
					sum += numbers[i + 1];
					continue;
				}
				if (a[i] == 1) {
					sum -= numbers[i + 1];
					continue;
				}
				if (a[i] == 2) {
					sum *= numbers[i + 1];
					continue;
				}
				if (a[i] == 3) {
					sum /= numbers[i + 1];
					continue;
				}
			}
			max = Math.max(max, sum);
			min = Math.min(min, sum);

		} while (next_permutation(a, n - 1));

		System.out.println(max);
		System.out.println(min);
	}

	public boolean next_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i -= 1;
		if (i <= 0)
			return false;
		int j = n - 1;
		while (a[i - 1] >= a[j])
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

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
