package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9935 {
	/* boj - 문자열 폭발 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String bomb = in.readLine();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
			if (sb.length() >= bomb.length() && sb.substring(sb.length() - bomb.length()).equals(bomb)) {
				sb.delete(sb.length() - bomb.length(), sb.length());
			}
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
