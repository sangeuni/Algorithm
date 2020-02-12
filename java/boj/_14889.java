package boj;

import java.util.Scanner;

public class _14889 {
	/*
	 * 스타트와 링크
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] s = new int[n][n];
		int[] a = new int[n];
		int[] start = new int[n / 2];
		int[] link = new int[n / 2];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				s[i][j] = sc.nextInt();
			}
		}
		for (int i = n / 2; i < a.length; i++) {
			a[i] = 1;
		}
		int answer = Integer.MAX_VALUE;
		int ps, pl;
		do {
			if (a[0] == 1)
				break;
			int idx = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == 0) {
					start[idx++] = i;
				}
			}
			idx = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == 1) {
					link[idx++] = i;
				}
			}
			ps = 0;
			pl = 0;
			ps = calc(s, start);
			pl = calc(s, link);
			answer = Math.min(answer, Math.abs(ps - pl));
		} while (next_permutation(a, n));
		System.out.println(answer);
	}

	public int calc(int[][] s, int[] team) {
		int sum = 0;
		for (int i = 0; i < team.length - 1; i++) {
			for (int j = i + 1; j < team.length; j++) {
				sum += s[team[i]][team[j]];
				sum += s[team[j]][team[i]];
			}
		}
		return sum;
	}

	public boolean next_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i -= 1;
		if (i <= 0)
			return false;
		int j = n - 1;
		while (a[i - 1] >= a[j])
			j -= 1;
		swap(a, i - 1, j);
		j = n - 1;
		while (i < j) {
			swap(a, i, j);
			i += 1;
			j -= 1;
		}
		return true;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
