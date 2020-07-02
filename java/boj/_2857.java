package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2857 {
	/* boj - FBI */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 1; i <= 5; i++) {
			if (br.readLine().contains("FBI")) {
				sb.append(i + " ");
				flag = true;
			}
		}

		if (flag) {
			bw.append(sb.toString().trim());
		} else {
			bw.append("HE GOT AWAY!");
		}
		bw.flush();
		bw.close();
	}
}
