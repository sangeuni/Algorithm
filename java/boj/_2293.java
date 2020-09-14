package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2293 {
	/* BOJ - 동전 */
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] coins = new int[n + 1];
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(reader.readLine());
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = coins[i]; j <= k; j++) {
				if(i == k) {
					answer = Math.min(answer, k/coins[i]);
				}
				dp[j] += dp[j - coins[i]];
			}
		}
		System.out.println(dp[k]);
	}

}
