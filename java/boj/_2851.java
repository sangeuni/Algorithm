package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _2851 {
	/* 슈퍼마리오 */
	List<Integer> list;

	public void go() {
		list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			list.add(sc.nextInt());
		}

		int answer = 0;
		for (int i = 0; i < 10; i++) {
			answer += list.get(i);
			if (answer >= 100) {
				answer = compare(answer, answer - list.get(i));
				break;
			}
		}
		System.out.println(answer);
	}

	public int compare(int a, int b) {
		if (Math.abs(100 - a) < Math.abs(100 - b)) {
			return a;
		} else if (Math.abs(100 - a) == Math.abs(100 - b)) {
			return a > b ? a : b;
		} else {
			return b;
		}
	}
}
