package boj;

import java.util.Scanner;

public class _13398 {
	/* 연속합 2
	 * - DP
	 * - Maximum Sub Array */
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
			d[i] = a[i];
			if (i == 0)
				continue;
			if (d[i - 1] + a[i] > a[i]) {
				d[i] = d[i - 1] + a[i];
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			d2[i] = a[i];
			if (i == n - 1)
				continue;
			if (d2[i + 1] + a[i] > a[i]) {
				d2[i] = d2[i + 1] + a[i];
			}
		}
		
		// 삭제하지 않아도 되므로, 기본 값을 삭제하지 않았을 때의 최대값으로 설정
		int max = d[0];
		for (int i = 1; i < n; i++) {
			max = Math.max(max, d[i]);
		}
		
		for (int i = 1; i < n - 1; i++) {
			max = Math.max(d[i - 1] + d2[i + 1], max);
		}
		System.out.println(max);
}
}
