package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _1620 {
	/* 나는야 포켓몬 마스터 이다솜 */
	static int n, m;
	static HashMap<String, Integer> word;
	static HashMap<Integer, String> number;

	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		init();
		String pocketmon;
		for (int i = 1; i <= n; i++) {
			pocketmon = br.readLine().trim();
			word.put(pocketmon, i);
			number.put(i, pocketmon);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			String quiz = br.readLine();
			if (Character.isDigit(quiz.charAt(0))) {
				sb.append(number.get(Integer.parseInt(quiz)) + '\n');
			} else {
				sb.append(Integer.toString(word.get(quiz)) + '\n');
			}
		}
		System.out.println(sb.toString());

	}

	public static void init() {
		word = new HashMap<>();
		number = new HashMap<>();
	}
}
