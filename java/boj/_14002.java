package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _14002 {
	/*
	 * 가장 긴 증가하는 부분 수열 4 - DS - LIS
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] d = new int[n];
		int[] prev = new int[n];
		List<Integer> answer = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		// for.부분 수열 길이
		int max = 1, point = 0;
		for (int i = 0; i < n; i++) {
			d[i] = 1;
			prev[i] = -1; // 새로 시작하는 수열은 이전 수열이 없으므로 -1
			for (int j = 0; j < i; j++) {
				if (a[j] < a[i] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
					prev[i] = j; // 이전 수열의 index
				}
				if (max < d[i]) {
					max = d[i];
					point = i; // 가장 긴 증가 부분 수열의 마지막 index
				}
			}
		}

		while (true) {
			int next = prev[point];
			answer.add(a[point]);
			if (next < 0) { // 부분 수열의 마지막 까지 왔을 때 종료
				break;
			}
			point = next;
		}

		System.out.println(max);
		// 역으로 출력
		for (int i = answer.size() - 1; i >= 0; i--) {
			System.out.print(answer.get(i) + " ");
		}
	}
}
