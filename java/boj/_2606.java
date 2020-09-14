package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _2606 {
	/* BOJ - 바이러스 */
	static int n, m, answer;
	static ArrayList<Integer>[] map;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(br.readLine());
		m = stoi(br.readLine());
		map = new ArrayList[n + 1];
		visited = new int[n + 1];

		for (int i = 0; i < map.length; i++) {
			map[i] = new ArrayList<>();
		}

		int a, b;
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = stoi(st.nextToken());
			b = stoi(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}

		answer = 0;
		dfs(1);
		System.out.println(answer);
	}

	static void dfs(int num) {
		visited[num] = 1;
		for (int pc : map[num]) {
			if (visited[pc] == 0) {
				answer++;
				dfs(pc);
			}
		}

	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
