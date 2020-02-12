package boj;

import java.util.Scanner;

public class _15651 {
	/* N과 M(3) */
	int[] a;
	StringBuilder sb = new StringBuilder();

	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		a = new int[10];

		System.out.print(make_permutation(0, n, m));
	}

	public StringBuilder make_permutation(int idx, int n, int m) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(a[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = 1; i <= n; i++) {
				a[idx] = i;
				make_permutation(idx + 1, n, m);
			}
		}
		return sb;
	}
}
