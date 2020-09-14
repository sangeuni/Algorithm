package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _17471_2 {
	/* BOJ - 게리맨더링 */
	static int n, answer, sum;
	static int[] area;
	static int[][] map;
	static List<Integer> list1, list2;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		area = new int[n + 1];
		map = new int[n + 1][n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			area[i + 1] = stoi(st.nextToken());
		}
		int a, b;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			a = stoi(st.nextToken());
			for (int j = 0; j < a; j++) {
				b = stoi(st.nextToken());
				map[i][b] = map[b][i] = 1;
			}
		}

		for (int i = 1; i < area.length; i++) {
			sum += area[i];
		}

		answer = Integer.MAX_VALUE;
		list1 = new ArrayList<>();
		permutation(1);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static void permutation(int start) {
		if (list1.size() >= n / 2) {
			return;
		}
		for (int i = start; i <= n; i++) {
			list1.add(i);
			solve();
			permutation(i + 1);
			list1.remove(Integer.valueOf(i));
		}
	}

	static void solve() {
		list2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!list1.contains(i + 1)) {
				list2.add(i + 1);
			}
		}

		int sum1 = 0;
		int sum2 = 0;
		if (isConnected(list1) && isConnected(list2)) {
			for (int i : list1) {
				sum1 += area[i];
			}
			for (int i : list2) {
				sum2 += area[i];
			}
			answer = Math.min(answer, Math.abs(sum1 - sum2));
		}
	}

	static boolean isConnected(List<Integer> list) {
		visited = new int[n + 1];
		dfs(list.get(0), list);
		for (int i : list) {
			if (visited[i] == 0) {
				return false;
			}
		}
		return true;
	}

	static void dfs(int start, List<Integer> list) {
		visited[start] = 1;

		for (int i = 1; i < list.size(); i++) {
			if (map[start][list.get(i)] == 1 && visited[list.get(i)] == 0) {
				dfs(list.get(i), list);
			}
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
