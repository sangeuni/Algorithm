package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2810 {
	/* boj - 컵홀더 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(in.readLine());
		String info = in.readLine();
		info = info.replaceAll("LL", "C");
		int answer = info.length() + 1;
		if (answer > n) {
			answer = n;
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
