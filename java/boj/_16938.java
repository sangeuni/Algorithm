package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _16938 {
	/* 
	 * 캠프 준비
	 */
	static int n, l, r, x, count;
	static int[] a;
	static List<Integer> p, temp;
	static boolean[] c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = stoi(st.nextToken());
		l = stoi(st.nextToken());
		r = stoi(st.nextToken());
		x = stoi(st.nextToken());
		init();

		st = new StringTokenizer(sc.nextLine());
		for (int i = 0; i < n; i++) {
			p.add(stoi(st.nextToken()));
		}
		count = 0;
		for (int i = 2; i <= p.size(); i++) {
			permutation(0, 1, i);
		}
		System.out.println(count);
	}

	public static void permutation(int depth, int start, int size) {
		if (depth == size) {
			temp = new ArrayList<>();
			solve();
			return;
		}

		for (int i = start; i <= n; i++) {
			a[depth] = i;
			permutation(depth + 1, i + 1, size);
		}
	}

	public static void solve() {
		for (int i : a) {
			if (i == 0)
				continue;
			temp.add(p.get(i-1));
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for(int i: temp) {
			sum += i;
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		if(sum < l || sum > r)
			return;
		if(max - min < x)
			return;
		
		count++;
	}

	public static void init() {
		a = new int[n];
		p = new ArrayList<>();
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
