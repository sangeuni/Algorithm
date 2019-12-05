package boj;

import java.util.Scanner;

public class _1932 {
	int d[][];
	int n;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n][n];

		d[0][0] = sc.nextInt();
		int num, max = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				num = sc.nextInt();
				if (j == 0) {
					d[i][j] = num + d[i - 1][j];
				} else if (i == j) {
					d[i][j] = num + d[i - 1][j - 1];
				} else {
					d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + num;
				}

				max = Math.max(max, d[i][j]);
			}
		}

		System.out.println(max);
	}
}
