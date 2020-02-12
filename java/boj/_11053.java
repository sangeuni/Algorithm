package boj;

import java.util.Scanner;

public class _11053 {
	/* 가장 긴 증가하는 부분 수열
	 * - DP
	 * - LIS 
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] d = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 1;
		for (int i = 0; i < n; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && d[j] + 1 > d[i]) {
					d[i] = d[j] + 1;
					max = Math.max(max, d[i]);
				}
			}
		}
		System.out.println(max);
	}
}
