package boj;

import java.util.Scanner;

public class _9498 {
	/* 시험점수 */
	int n;
	String answer;

	private void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		switch (n / 10) {
		case 10:
		case 9:
			answer = "A";
			break;
		case 8:
			answer = "B";
			break;
		case 7:
			answer = "C";
			break;
		case 6:
			answer = "D";
			break;
		default:
			answer = "F";
			break;

		}
		System.out.print(answer);
	}
}
