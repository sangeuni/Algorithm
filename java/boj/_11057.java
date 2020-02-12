package boj;

import java.util.Scanner;

public class _11057 {
	/*
	 * 오르막 수 - dp
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] d = new int[1001][10];

		for (int i = 0; i <= 9; i++) {
			d[1][i] = 1;
		}
		for (int i = 2; i <= 1000; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += d[i - 1][k];
					d[i][j] %= 10007;
				}
			}
		}
		long answer = 0;
		for (int i = 0; i <= 9; i++) {
			answer += d[n][i];
		}
		System.out.println(answer % 10007);
	}
}
