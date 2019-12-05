package boj;

import java.util.Scanner;

public class _9095 {
	// 1, 2, 3 더하기
	int[] d = new int[12];

	private void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int x = sc.nextInt();
			System.out.println(dp(x));
		}
	}

	private int dp(int x) {
		if (x == 1)
			return 1;
		if (x == 2)
			return 2;
		if (x == 3)
			return 4;
		if (d[x] != 0)
			return d[x];
		return (dp(x - 1) + dp(x - 2) + dp(x - 3));
	}
}
