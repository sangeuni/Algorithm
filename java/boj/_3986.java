package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _3986 {
	/* boj - 좋은 단어 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi(br.readLine());
		int answer = 0;
		Stack<Character> s;
		while (n-- > 0) {
			s = new Stack<>();
			String word = br.readLine();
			for (int i = 0; i < word.length(); i++) {
				if (!s.isEmpty()) {
					if (s.peek() == word.charAt(i)) {
						s.pop();
					} else {
						s.push(word.charAt(i));
					}
				} else {
					s.push(word.charAt(i));
				}
			}

			if (s.isEmpty())
				answer++;
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
