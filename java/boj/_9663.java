package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9663 {
	/* 
	 * N-Queen 
	 */
	static int n, answer = 0;
	static boolean[] col = new boolean[15];
	static boolean[] dig1 = new boolean[30];
	static boolean[] dig2 = new boolean[30];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = stoi(st.nextToken());
		calc(0);
		System.out.println(answer);

	}

	static boolean check(int r, int c) {
		// col
		if (col[c])
			return false;

		// 오른쪽 대각선
		if (dig1[r + c])
			return false;

		// 왼쪽 대각선
		if (dig2[r - c + n])
			return false;
		return true;
	}

	static void calc(int row) {
		if (row == n) {
			answer += 1;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (check(row, i)) {
				col[i] = true;
				dig1[row + i] = true;
				dig2[row - i + n] = true;
				calc(row + 1);
				col[i] = false;
				dig1[row + i] = false;
				dig2[row - i + n] = false;
			}
		}

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
