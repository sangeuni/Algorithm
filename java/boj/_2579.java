package boj;

import java.util.Scanner;

public class _2579 {
	// 계단 오르기
	int[] d;
	int[] arr;

	private void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n + 1];
		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		d[1] = arr[1];
		d[2] = d[1] + arr[2];
		for (int i = 3; i <= n; i++) {
			d[i] = Math.max(arr[i] + d[i - 2], arr[i] + d[i - 3] + arr[i - 1]);
		}
		System.out.println(d[n]);
	}
}
