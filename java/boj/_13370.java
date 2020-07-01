package boj;

import java.util.Scanner;

public class _13370 {
	/* 크로아티아 알파벳 */
	static String[] croatia = new String[] { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = 0;
		for (int i = 0; i < croatia.length; i++) {
			s = s.replaceAll(croatia[i], Integer.toString(i));
		}
		System.out.println(s.length());
	}
}
