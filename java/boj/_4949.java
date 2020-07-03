package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _4949 {
	/* boj - 균형잡힌 세상 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String input = in.readLine();
			if (input.equals("."))
				break;

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if (ch == '(' || ch == ')' || ch == '[' || ch == ']') {
					sb.append(ch);
				}
			}
			Stack<Character> s = new Stack<>();
			for (int i = 0; i < sb.length(); i++) {
				if (s.isEmpty()) {
					s.push(sb.charAt(i));
				} else if (s.peek() == '(' && sb.charAt(i) == ')') {
					s.pop();
				} else if (s.peek() == '[' && sb.charAt(i) == ']') {
					s.pop();
				} else {
					s.push(sb.charAt(i));
				}
			}
			System.out.println(s.isEmpty() ? "yes" : "no");
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
