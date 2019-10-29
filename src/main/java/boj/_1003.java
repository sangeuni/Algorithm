package boj;

import java.util.Scanner;

public class _1003 {
	// 피보나치
	int zero[] = new int[41];
	int one[] = new int[41];

	private void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		zero[0] = 1;
		one[1] = 1;

		for (int i = 2; i <= 40; i++) {
			zero[i] = zero[i - 1] + zero[i - 2];
			one[i] = one[i - 1] + one[i - 2];
		}

		for (int i = 0; i < n; i++) {
			int input = sc.nextInt();
			System.out.println(zero[input] + " " + one[input]);
		}
	}
}