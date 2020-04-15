package boj;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _15663 {
	/* N과 M(9) */
	static String[] a;
	static int[] num;
	static boolean[] c;
	static int n, m;
	static StringBuilder sb;
	static Set<String> set;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		set = new LinkedHashSet<>();

		n = sc.nextInt();
		m = sc.nextInt();

		a = new String[m];
		num = new int[n];
		c = new boolean[n];

		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}

		Arrays.sort(num);
		permutation(0);

		for (String s : set) {
			System.out.println(s);
		}
	}

	static void permutation(int count) {
		if (count == m) {
			sb = new StringBuilder();
			for (String s : a) {
				sb.append(s + " ");
			}
			set.add(sb.toString());
			return;
		}
		for (int i = 0; i < n; i++) {
			if (c[i])
				continue;
			c[i] = true;
			a[count] = Integer.toString(num[i]);
			permutation(count + 1);
			c[i] = false;
		}
	}
}
