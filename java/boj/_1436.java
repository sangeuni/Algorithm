package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1436 {
	/* BOJ - 영화감독 숌 */
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int num = 0;

		while (N > 0) {
			num++;
			String s = String.valueOf(num);

			if (s.contains("666"))
				N--;
		}

		System.out.println(num);
	}
}
