package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _7785 {
	/* 회사에 있는 사람 */
	static int n;
	static Set<String> log;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		init();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine().trim());
			String name = st.nextToken();
			if (st.nextToken().equals("enter")) {
				log.add(name);
			} else {
				log.remove(name);
			}
		}

		StringBuilder sb = new StringBuilder();
		String[] nameArr = new String[log.size()];
		log.toArray(nameArr);
		Arrays.sort(nameArr);
		for (int i = nameArr.length - 1; i >= 0; i--) {
			sb.append(nameArr[i] + '\n');
		}
		System.out.println(sb.toString());
	}

	public static void init() {
		log = new HashSet<>();
	}
}
