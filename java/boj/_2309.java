package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _2309 {
	/* 일곱 난쟁이: Brute Force */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] nan = new int[9];
		for (int i = 0; i < 9; i++) {
			int h = sc.nextInt();
			nan[i] = h;
			sum += h;
		}

		Arrays.sort(nan);
		loop: for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - nan[i] - nan[j] == 100) {
					for (int k = 0; k < 9; k++) {
						if (k == i || k == j)
							continue;
						System.out.println(nan[k]);
					}
					break loop;
				}
			}
		}
	}
}
