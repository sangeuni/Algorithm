package algorithm;

import java.io.IOException;

public class DisjointSet {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		parent = new int[9];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
//		union(1,2);
//		union(4,5);
//		union(6,1);
//		union(3,7);
//		union(7,8);
//		union(2,5);
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
}
