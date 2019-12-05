package boj;

import java.util.Scanner;

public class _1924 {
	/* 2007년 */
	int x, y;
	String answer;

	private void go() {
		Scanner sc = new Scanner(System.in);
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		x = sc.nextInt();
		y = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < x - 1; i++) {
			sum += month[i];
		}
		sum += y;
		System.out.println(days[sum % 7]);
	}
}
