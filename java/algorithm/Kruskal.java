package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal {
	static int v, e, answer;
	static int[] parent;
	static PriorityQueue<Edge> pq;

	static class Edge implements Comparable<Edge> {
		private int start;
		private int end;
		private int value;

		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		v = stoi(in.readLine());
		e = stoi(in.readLine());

		pq = new PriorityQueue<>();
		StringTokenizer st;
		int start, end, value;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(in.readLine());
			start = stoi(st.nextToken());
			end = stoi(st.nextToken());
			value = stoi(st.nextToken());
			pq.add(new Edge(start, end, value));	// [시작, 끝, 비용]을 가진 Edge 클래스로 우선순위 큐에 add
		}

		// Disjoint Set 초기화, 부모 = 자기 자신
		parent = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		answer = 0;
		mst();
		System.out.println(answer);
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int start, int end) {
		start = find(start);
		end = find(end);
		if (start != end) {
			parent[end] = start;
		}
	}

	static void mst() {
		for (int i = 1; i <= e; i++) {	// 모든 간선에 대해 확인
			Edge edge = pq.poll();	// 비용이 작은 간선 부터 차례대로 꺼낸다.
			int a = find(edge.start);
			int b = find(edge.end);

			if (a != b) {	// 사이클이 생기는지 확인
				union(edge.start, edge.end);	// 사이클이 생기지 않는다면 연결
				answer += edge.value;
			}
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}

// input
// 7
// 11
// 1 2 2
// 2 7 7
// 7 6 9
// 6 5 23
// 5 4 1
// 4 1 10
// 1 3 3
// 2 3 3
// 3 7 4
// 3 6 3
// 3 5 6
// output
// 19
