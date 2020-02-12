package boj;

import java.util.Scanner;

public class _15469 {
	/* N과 M(1) */
	int[] a;
	boolean[] c;

	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		a = new int[m];
		c = new boolean[n + 1];

		make_permutation(0, n, m);
	}

	public void make_permutation(int idx, int n, int m) {
		if (idx == m) {
			print(a);
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (c[i])
				continue;
			c[i] = true;
			a[idx] = i;
			make_permutation(idx + 1, n, m);
			c[i] = false;
		}
	}

	public void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
