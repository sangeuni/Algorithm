package boj;

import java.util.Scanner;

public class _10971 {
	/* 
	 * 외판원 순회 2 - Permutation
	 * 모든 도시를 거쳐 원래의 도시로 돌아오는 순회 여행이기 때문에
	 * 첫번째 도시는 고정하고, 나머지 도시의 순서만 구한다 !
	*/
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[][] w = new int[n][n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
			for (int j = 0; j < n; j++)
				w[i][j] = sc.nextInt();
		}
		int ans = Integer.MAX_VALUE;
		do {
			int cost = 0;
			boolean ok = true;
			for (int i = 1; i < n; i++) {
				if (w[a[i - 1]][a[i]] != 0) {
					cost += w[a[i - 1]][a[i]];
				} else {
					ok = false;
				}
			}

			if (ok && w[a[n - 1]][a[0]] != 0) {
				cost += w[a[n - 1]][a[0]];
				ans = Math.min(cost, ans);
			}
		} while (next_permutation(a, n));

		System.out.println(ans);
	}

	private boolean next_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 1 && a[i - 1] >= a[i]) // a[]의 첫번째 인덱스는 고정이기 때문에, i>1
			i -= 1;
		if (i <= 1)	// a[]의 첫번째 인덱스는 고정이기 때문에, i>1
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

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
