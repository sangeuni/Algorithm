package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2294 {
	/* BOJ - 동전 2 */
	static int n, k;
	static int[] coins;
	static Case[] dp;

	static class Case {
		private int num;
		private int count;

		public Case() {
			this.num = 0;
			this.count = Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.valueOf(st.nextToken());
		k = Integer.valueOf(st.nextToken());

		coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.valueOf(br.readLine());
		}

		Arrays.sort(coins);

		dp = new Case[k + 1];
		for (int i = 0; i <= k; i++) {
			dp[i] = new Case();
		}

		dp[0].num = 1;
		dp[0].count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				dp[j].num += dp[j - coins[i]].num;
				if (dp[j - coins[i]].num == 0)
					continue;
				dp[j].count = Math.min(dp[j].count, dp[j - coins[i]].count + 1);
			}
		}
		System.out.println(dp[k].count == Integer.MAX_VALUE ? -1 : dp[k].count);
	}

}
