package codingtest;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Boost2 {
	static class Pair implements Comparable<Pair> {
		private int value;
		private int count;

		public Pair(int value, int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Pair [value=" + value + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Pair o) {
			return o.value - this.value;
		}
	}

	public static void main(String[] args) throws IOException {

		System.out.println(solution(new int[] { 1, 2, 2, 3, 2, 2, 2 }, new int[] { 4, 5, 4, 5, 4, 5, 4 }));
	}

	static int solution(int[] arr1, int[] arr2) {
		int answer = 0;
		int[] count1 = new int[14], count2 = new int[14];

		for (int i = 0; i < arr1.length; i++) {
			count1[arr1[i]]++;
			count2[arr2[i]]++;
		}

		List<Pair> list1 = new LinkedList<>();
		List<Pair> list2 = new LinkedList<>();

		for (int i = 0; i < count1.length; i++) {
			if (count1[i] >= 2) {
				if (count1[i] > 4)
					count1[i] = 4;
				list1.add(new Pair(i, count1[i]));
			}
			if (count2[i] >= 2) {
				if (count2[i] > 4)
					count2[i] = 4;
				list2.add(new Pair(i, count2[i]));
			}
		}

		if (list1.size() == 0 && list2.size() == 0) {
			return 0;
		} else if (list1.size() == 0 || list2.size() == 0) {
			return list1.size() > list2.size() ? 1 : 2;
		} else {
			Collections.sort(list1);
			Collections.sort(list2);
			System.out.println(list1.get(0) + " " + list2.get(0));
			return comparePair(list1.get(0), list2.get(0));
		}
	}

	static int comparePair(Pair p1, Pair p2) {
		if (p1.count > p2.count) {
			return 1;
		} else if (p1.count < p2.count) {
			return 2;
		} else if (p1.count == p2.count) {
			return p1.value > p2.value ? 1 : 2;
		}
		return 0;
	}
}