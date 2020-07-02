package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2892 {
	/* boj - 심심한 준규 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = stoi(br.readLine());
		String[] arr = br.readLine().split(" ");

		StringBuilder sb = new StringBuilder();
		for (String s : arr) {
			if (Integer.parseInt(s, 16) >= 64 && Integer.parseInt(s, 16) <= 95) {
				sb.append("-");
			} else {
				sb.append(".");
			}
		}
		bw.write(sb.toString());
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
