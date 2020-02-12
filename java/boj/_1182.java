package boj;

import java.util.Scanner;

public class _1182 {
	/* 부분 수열의 합 - BF(Recursion) */
	int n;
	int goal;
	private static int ans = 0;

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		goal = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		combination(a, 0, 0);
		if (goal == 0)
			ans -= 1;
		System.out.println(ans);
	}

	public void combination(int[] a, int idx, int sum) {
		if (idx == n && sum == goal) {
			ans++;
			return;
		}
		if (idx == n && sum != goal)
			return;
		combination(a, idx + 1, sum + a[idx]);
		combination(a, idx + 1, sum);
	}
}
