package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _10972 {
	/* 다음 순열 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();

		if (next_permutation(a, n)) {
			for (int i : a)
				System.out.print(i + " ");
		} else
			System.out.println(-1);
	}

	public boolean next_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i]) // a[i-1] <= a[i]를 만족하는 가장 큰 i 찾기
			i -= 1;
		if (i <= 0)
			return false;
		int j = n - 1;
		while (a[i - 1] >= a[j]) // 오른쪽에서 i-1보다 크면서 가장 작은 j 찾기
			j -= 1;
		swap(a, i - 1, j); // i-1과 j swap
		j = n - 1;

		Arrays.sort(a, i, n); // i부터 배열 끝까지 오름차순 sort
		return true;
	}

	public void swap(int[] n, int i, int j) {
		int temp = n[i];
		n[i] = n[j];
		n[j] = temp;
	}
}
