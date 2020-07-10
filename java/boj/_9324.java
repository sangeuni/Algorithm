package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9324 {
	/* boj - 진짜 메시지 */
	static int[] alpha;
	static char prev;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(in.readLine());
		while (tc-- > 0) {
			String s = in.readLine();
			init();
			String result = "FAKE";
			for (int i = 0; i < s.length(); i++) {
				if (flag) {
					if (prev == s.charAt(i)) {
						flag = false;
						alpha[s.charAt(i) - 'A'] = 0;
					} else {
						break;
					}
				} else {
					alpha[s.charAt(i) - 'A']++;

					if (alpha[s.charAt(i) - 'A'] >= 3) {
						flag = true;
						prev = s.charAt(i);
					}
				}
				if (i == s.length() - 1 && !flag) {
					result = "OK";
				} else {
					result = "FAKE";
				}
			}
			System.out.println(result);
		}
	}

	static void init() {
		alpha = new int[26];
		prev = ' ';
		flag = false;
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
