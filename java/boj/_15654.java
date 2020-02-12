package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _15654 {
	/* N과M(5) */
	int[] a;
	boolean[] c;
	int[] temp_arr;
	StringBuilder sb = new StringBuilder();

	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		a = new int[n];
		c = new boolean[n];
		temp_arr = new int[m];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		System.out.print(make_permutation(0, n, m));
	}

	public StringBuilder make_permutation(int idx, int n, int m) {
		if (idx == m) {
			for (int i = 0; i < m; i++) {
				sb.append(temp_arr[i] + " ");
			}
			sb.append("\n");
		} else {
			for (int i = 0; i < n; i++) {
				if (c[i])
					continue;
				c[i] = true;
				temp_arr[idx] = a[i];
				make_permutation(idx + 1, n, m);
				c[i] = false;
			}
		}
		return sb;
	}
}
