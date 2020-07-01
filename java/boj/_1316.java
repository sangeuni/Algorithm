package boj;

import java.io.IOException;
import java.util.Scanner;

public class _1316 {
	/* boj - 그룹단어체커 */
	static boolean[] alpha;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		int count = 0;
		loop: while (n-- > 0) {
			String s = sc.nextLine();
			init();
			char prev = s.charAt(0);
			alpha[s.charAt(0) - 'a'] = true;
			for (int i = 1; i < s.length(); i++) {
				if (prev == s.charAt(i)) {
					continue;
				} else if (!alpha[s.charAt(i) - 'a']) {
					alpha[s.charAt(i) - 'a'] = true;

					prev = s.charAt(i);
				} else {
					continue loop;
				}
			}
			count++;
		}
		System.out.println(count);
	}

	static void init() {
		alpha = new boolean[26];
	}
}
