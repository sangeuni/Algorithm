package boj;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _9375 {
	/* 패션왕 신해빈 */
	static int tc, answer;
	static HashMap<String, Integer> map;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();

		while (tc-- > 0) {
			answer = sc.nextInt();
			sc.nextLine();
			init();
			for (int i = 0; i < answer; i++) {
				st = new StringTokenizer(sc.nextLine());
				st.nextToken();
				String item = st.nextToken();
				if (map.containsKey(item)) {
					map.replace(item, map.get(item) + 1);
				} else {
					map.put(item, 1);
				}
			}

			answer = 1;
			for (String key : map.keySet()) {
				answer *= (map.get(key) + 1);
			}
			answer -= 1;
			System.out.println(answer);
		}
	}

	public static void init() {
		map = new HashMap<>();
	}
}
