package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class _7568 {
	/* BOJ - 덩치 */
	static int n;
	static List<Person> list;

	static class Person implements Comparable<Person> {
		private int idx;
		private int x;
		private int y;
		private int rank;

		public Person(int idx, int x, int y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.rank = 1;
		}

		@Override
		public int compareTo(Person o) {
			return this.x - o.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		list = new ArrayList<>();
		StringTokenizer st;
		int x, y;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = stoi(st.nextToken());
			y = stoi(st.nextToken());

			list.add(new Person(i, x, y));
		}

		Collections.sort(list);

		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n; j++) {
				if (list.get(i).x < list.get(j).x && list.get(i).y < list.get(j).y) {
					list.get(i).rank++;
				}
			}
		}

		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.idx - o2.idx;
			}
		});

		for (Person p : list) {
			System.out.print(p.rank + " ");
		}
		System.out.println();
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}

}
