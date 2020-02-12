package boj;

import java.util.Scanner;

public class _1912 {
	/*
	 * 연속합 
	 * - DP 
	 * - Maximum Sub Array
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int max = a[0];
		d[0] = a[0];
		for (int i = 1; i < n; i++) {
			d[i] = a[i];
			if (d[i - 1] + a[i] > a[i]) {
				d[i] = d[i - 1] + a[i];
			}
			max = Math.max(d[i], max);
		}

		System.out.println(max);
	}
}
