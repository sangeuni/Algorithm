package boj;

import java.util.Scanner;

public class _11052 {
	/* 
	 * d[i] = deck[n] + d[i-n] 
	 */
	int n;
	int[] d;
	int[] deck;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		d = new int[n + 1];
		deck = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			deck[i] = sc.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				d[i] = Math.max(d[i], deck[j] + d[i - j]);
			}
			System.out.println();
		}

		System.out.println(d[n]);
	}
}
