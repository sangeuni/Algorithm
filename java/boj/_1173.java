package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1173 {
	/* boj - 1173 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int T = stoi(st.nextToken());
		int R = stoi(st.nextToken());
		int time = 0, X = m;
		if (m + T > M) {
			time = -1;
		} else {
			while (true) {
				if (N <= 0)
					break;
				if (X + T <= M) {
					X += T;
					N--;
				} else if (X - R >= m) {
					X -= R;

				} else {
					X = m;
				}
				time++;
			}
		}
		System.out.println(time);

	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
