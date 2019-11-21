package boj;

import java.util.Scanner;

public class _2839 {
	/* 설탕 배달 */
	int n;
	int count = 0;

	private void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		while (true) {
			if (n % 5 == 0) {
				count += n / 5;
				break;
			} else if (n <= 0) {
				count = -1;
				break;
			}

			n -= 3;
			count++;
		}

		System.out.println(count);
	}
}
