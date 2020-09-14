package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9012 {
	/* BOJ - 괄호 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = stoi(br.readLine());
		while (n-- > 0) {
			char[] arr = br.readLine().toCharArray();
			String answer = "YES";
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == '(') {
					count++;
				} else {
					count--;
				}

				if (count < 0) {
					answer = "NO";
					break;
				}
			}

			if (count != 0)
				answer = "NO";
			System.out.println(answer);
		}

	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}
