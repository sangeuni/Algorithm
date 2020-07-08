package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1717 {
	/* boj - 집합의 표현 */
	static StringTokenizer st;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(in.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		parent = new int[n + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		while (m-- > 0) {
			st = new StringTokenizer(in.readLine());
			int op, a, b;
			op = stoi(st.nextToken());
			a = stoi(st.nextToken());
			b = stoi(st.nextToken());
			if (op == 0) {
				union(a, b);
				continue;
			}
			System.out.println(find(a) == find(b) ? "YES" : "NO");
		}
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}

	static int find(int n) {
		if (parent[n] == n) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
