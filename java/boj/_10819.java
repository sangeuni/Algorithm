package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _10819 {
	/* 차이를 최대로 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		int max = 0;
		do {
			int sum = calculate(a, n);
			max = Math.max(sum, max);
		} while (next_permutation(a, n));

		System.out.println(max);
	}

	private int calculate(int[] a, int n) {
		int sum = 0;
		for (int i = 0; i < n - 1; i++)
			sum += Math.abs(a[i] - a[i + 1]);
		return sum;
	}

	private boolean next_permutation(int[] a, int n) {
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

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
