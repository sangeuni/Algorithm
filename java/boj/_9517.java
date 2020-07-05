package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9517 {
	/* boj - 아이 러브 크로아티아 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int player = stoi(in.readLine());
		int n = stoi(in.readLine());
		int time = 0;
		StringTokenizer st;
		while (n-- > 0) {
			st = new StringTokenizer(in.readLine());
			time += stoi(st.nextToken());
			String result = st.nextToken();

			if (time >= 230) {
				break;
			}

			if (result.equals("T")) {
				player = (player == 8) ? 1 : player + 1;
			}
		}
		System.out.println(player);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
