package boj;

import java.util.Scanner;

public class _18763 {
	/* boj - 상수 */
	static StringBuilder sb1, sb2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		for (int i = 2; i >= 0; i--) {
			sb1.append(Integer.toString(a).charAt(i));
			sb2.append(Integer.toString(b).charAt(i));
		}
		System.out.println(
				Integer.parseInt(sb1.toString()) > Integer.parseInt(sb2.toString()) ? sb1.toString() : sb2.toString());
	}
}
