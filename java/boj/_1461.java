package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class _1461 {
	/* boj - 도서관 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());

		st = new StringTokenizer(in.readLine());
		List<Integer> left = new LinkedList<>();
		List<Integer> right = new LinkedList<>();

		while (st.hasMoreTokens()) {
			int index = stoi(st.nextToken());
			if (index < 0) {
				left.add(index);
			} else {
				right.add(index);
			}
		}

		Collections.sort(left);
		Collections.sort(right, Collections.reverseOrder());

		List<Integer> count = new LinkedList<>();
		int lc = left.size() / m;
		int rc = right.size() / m;
		for (int i = 0; i < lc * m; i += m) {
			count.add(Math.abs(left.get(i)));
		}
		for (int i = 0; i < rc * m; i += m) {
			count.add(right.get(i));
		}

		if (left.size() % m != 0)
			count.add(Math.abs(left.get(lc * m)));
		if (right.size() % m != 0)
			count.add(right.get(rc * m));

		Collections.sort(count, Collections.reverseOrder());

		int answer = 0;
		for (int i = 0; i < count.size(); i++) {
			if (i == 0)
				answer += count.get(i);
			else
				answer += (count.get(i) * 2);
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
