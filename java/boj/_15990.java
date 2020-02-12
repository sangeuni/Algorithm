package boj;

import java.util.Scanner;

public class _15990 {
	/* 1, 2, 3 더하기 
	 * - dp
	 */
	private static final long MOD = 1000000009L;
	private static final int N = 100000;

	public void go() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		long[][] d = new long[N + 1][4];

		for (int i = 1; i <= N; i++) {
			if (i - 1 >= 0) {
				d[i][1] = d[i - 1][2] + d[i - 1][3];
				if (i == 1) {
					d[i][1] = 1;
				}
			}
			if (i - 2 >= 0) {
				d[i][2] = d[i - 2][1] + d[i - 2][3];
				if (i == 2) {
					d[i][2] = 1;
				}
			}
			if (i - 3 >= 0) {
				d[i][3] = d[i - 3][1] + d[i - 3][2];
				if (i == 3) {
					d[i][3] = 1;
				}
			}
			d[i][1] %= MOD;
			d[i][2] %= MOD;
			d[i][3] %= MOD;
		}
		while (tc-- > 0) {
			int n = sc.nextInt();
			long answer = d[n][1] + d[n][2] + d[n][3];
			System.out.println(answer % MOD);
		}
	}
}
