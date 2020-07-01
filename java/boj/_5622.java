package boj;

import java.util.Scanner;

public class _5622 {
	/* boj - 다이얼 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();

		int answer = 0;
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			if (ch == 'A' || ch == 'B' || ch == 'C') {
				answer += 3;
			} else if (ch == 'D' || ch == 'E' || ch == 'F') {
				answer += 4;
			} else if (ch == 'G' || ch == 'H' || ch == 'I') {
				answer += 5;
			} else if (ch == 'J' || ch == 'K' || ch == 'L') {
				answer += 6;
			} else if (ch == 'M' || ch == 'N' || ch == 'O') {
				answer += 7;
			} else if (ch == 'P' || ch == 'Q' || ch == 'R' || ch == 'S') {
				answer += 8;
			} else if (ch == 'T' || ch == 'U' || ch == 'V') {
				answer += 9;
			} else {
				answer += 10;
			}
		}
		System.out.println(answer);
	}
}
