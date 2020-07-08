package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1976 {
	/* boj - 여행가자 */
	static StringTokenizer st;
	static int[] parent, plan;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = stoi(in.readLine());
		m = stoi(in.readLine());
		init();

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j <= i; j++) {
				if(stoi(st.nextToken()) == 1) {
					union(i+1,j+1);
				}
			}
		}
		
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i<plan.length; i++) {
			plan[i] = stoi(st.nextToken());
		}
		
		int root = find(plan[0]);
		String result = "YES";
		for(int i = 1; i<plan.length; i++) {
			int temp = find(plan[i]);
			if(root != temp) {
				result = "NO";
				break;
			}
		}
		System.out.println(result);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			if (a == parent[a]) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
	}

	static int find(int n) {
		if (n == parent[n]) {
			return n;
		}
		return parent[n] = find(parent[n]);
	}

	static void init() {
		parent = new int[n + 1];
		plan = new int[m];
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
