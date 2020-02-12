package boj;

import java.util.Scanner;

public class _11054 {
	/* 가장 긴 바이토닉 부분 수열
	 * - DP
	 * - LIS */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];
		int[] d2 = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && d[j] + 1 > d[i]) {
					d[i] = d[j] + 1;
				}
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			d2[i] = 1;
			for (int j = n - 1; j > i; j--) {
				if (a[i] > a[j] && d2[j] + 1 > d2[i]) {
					d2[i] = d2[j] + 1;
				}
			}
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			max = Math.max(d[i] + d2[i] - 1, max);
		}
		System.out.println(max);

	}
}
