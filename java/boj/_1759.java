package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _1759 {
	/* 암호 만들기 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt(); // 암호의 길이
		int c = sc.nextInt();
		sc.nextLine();
		String[] alpha = sc.nextLine().split(" ");
		Arrays.sort(alpha);
		combination(alpha, "", 0, l);

	}

	public void combination(String[] alpha, String password, int idx, int l) {
		if (password.length() == l && check(password)) {
			System.out.println(password);
			return;
		}
		if (idx >= alpha.length)
			return;
		combination(alpha, password + alpha[idx], idx + 1, l);
		combination(alpha, password, idx + 1, l);
	}

	public boolean check(String password) {
		int ja = 0;
		int mo = 0;
		for (int i = 0; i < password.length(); i++) {
			char ch = password.charAt(i);
			if (ch == 'a' || ch == 'i' || ch == 'u' || ch == 'e' || ch == 'o')
				mo += 1;
			else
				ja += 1;
		}
		return mo >= 1 && ja >= 2;
	}

}
