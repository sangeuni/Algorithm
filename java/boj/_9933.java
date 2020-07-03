package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _9933 {
	/* boj - 민균이의 비밀번호 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(in.readLine());
		String[] s = new String[n], r = new String[n];

		String word;
		for (int i = 0; i < n; i++) {
			word = in.readLine();
			s[i] = word;
			r[i] = reverse(word);
		}
		Arrays.sort(r, Collections.reverseOrder());
		String answer = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (s[i].equals(r[j])) {
					answer = s[i];
					break;
				}
			}
		}
		System.out.println(answer.length() + " " + answer.charAt(answer.length() / 2));
	}

	static String reverse(String word) {
		StringBuilder sb = new StringBuilder();
		for (int i = word.length() - 1; i >= 0; i--) {
			sb.append(word.charAt(i));
		}
		return sb.toString();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
