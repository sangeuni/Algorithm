package boj;

import java.util.Scanner;

public class _10844 {
	/* 쉬운 계단 수 */
	private static final long MOD = 1000000000L;

	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[101][10];

		for (int i = 1; i <= 9; i++) {
			d[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j - 1 >= 0)
					d[i][j] += d[i - 1][j - 1];
				if (j + 1 < 10)
					d[i][j] += d[i - 1][j + 1];

				d[i][j] %= MOD;
			}
		}
		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer += d[n][i];
		}
		System.out.println(answer % MOD);
	}
}
