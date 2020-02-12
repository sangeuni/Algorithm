package boj;

import java.util.Scanner;

public class _11055 {
	/* 가장 큰 증가 부분 수열
	 * - DP
	 * - LIS
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int max = 1;
		for (int i = 0; i < n; i++) {
			d[i] = a[i];
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && d[i] < d[j] + a[i]) {
					d[i] = d[j] + a[i];
				}
			}
			max = Math.max(max, d[i]);
		}
		System.out.println(max);
	}
}
