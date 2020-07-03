package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9996 {
	/* boj - 한국이 그리울 땐 서버에 접속하지 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int n = stoi(in.readLine());

		String[] pattern = in.readLine().split("\\*");
		int start = pattern[0].length();
		int end = pattern[1].length();
		for (int i = 0; i < n; i++) {
			String name = in.readLine();
			if (name.length() < start + end) {
				System.out.println("NE");
			} else if (name.substring(0, start).equals(pattern[0])
					&& name.substring(name.length() - end).equals(pattern[1])) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
