package boj;

import java.util.Scanner;

public class _1476 {
	/* 날짜 계산: Brute Force */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int e, s, m;
		e = sc.nextInt();
		s = sc.nextInt();
		m = sc.nextInt();
		int E = 1;
		int S = 1;
		int M = 1;

		for (int i = 1;; i++) {
			if (E == e && S == s && M == m) {
				System.out.println(i);
				break;
			}
			E++;
			S++;
			M++;

			if (E == 16)
				E = 1;
			if (S == 29)
				S = 1;
			if (M == 20)
				M = 1;
		}
	}
}