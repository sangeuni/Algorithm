package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _17471 {
	/* 
	 * 게리멘더링
	 */
	static int n, min;
	static int[] a, visited;
	static int[][] map;
	static List<Integer> area;
	static List<Integer> first;
	static List<Integer> second;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());

		n = stoi(st.nextToken());

		area = new ArrayList<>();
		area.add(0);
		st = new StringTokenizer(sc.nextLine());
		for (int i = 1; i <= n; i++) {
			area.add(i, stoi(st.nextToken()));
		}

		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(sc.nextLine());
			int m = stoi(st.nextToken());
			for (int j = 0; j < m; j++) {
				int area = stoi(st.nextToken());
				map[i][area] = 1;
			}
		}
		a = new int[n + 1];
		min = Integer.MAX_VALUE;
		for (int i = 1; i <= n / 2; i++) {
			permutation(0, 1, i);
		}
		if (min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

	static void permutation(int depth, int start, int size) {
		if (depth == size) {
			simulation();
			return;
		}

		for (int i = start; i <= n; i++) {
			a[i] = 1;
			permutation(depth + 1, i + 1, size);
			a[i] = 0;
		}
	}

	static void simulation() {
		first = new ArrayList<>();
		second = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (a[i] == 1)
				first.add(i);
			else
				second.add(i);
		}

		int f = 0;
		int s = 0;
		if (isConnected(first) && isConnected(second)) {
			for (int i : first) {
				f += area.get(i);
			}
			for (int i : second) {
				s += area.get(i);
			}
			min = Math.min(min, Math.abs(f - s));
		}

	}

	static boolean isConnected(List<Integer> list) {
		visited = new int[n + 1];
		if (list.size() == 1)
			return true;
		dfs(list.get(0), list);
		for (int i : list) {
			if (visited[i] == 0)
				return false;
		}
		return true;
	}

	static void dfs(int cur, List<Integer> list) {
		visited[cur] = 1;
		for (int i = 1; i < list.size(); i++) {
			if (map[cur][list.get(i)] == 1 && visited[list.get(i)] == 0)
				dfs(list.get(i), list);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
