package boj;

import java.util.Scanner;

public class _11727 {
	/* 
	 * dp[n] = dp[n-1] + 2dp[n-2] 
	 * */
	int n;
	int[] d = new int[1001];

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(dp(n));
	}

	private int dp(int x) {
		if (x == 1)
			return 1;
		if (x == 2)
			return 3;

		if (d[x] != 0)
			return d[x];
		return d[x] = (dp(x - 1) + 2 * dp(x - 2)) % 10007;
	}
}
