package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class _1916 {
	/* boj - 최소 비용 구하기 */
	static int V, E;
	static List<List<Node>> graph;
	static int[] distance;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		private int idx;
		private int weight;

		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = stoi(br.readLine());
		E = stoi(br.readLine());

		init();

		StringTokenizer st;
		int u, v, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = stoi(st.nextToken());
			v = stoi(st.nextToken());
			w = stoi(st.nextToken());
			graph.get(u).add(new Node(v, w));
		}

		st = new StringTokenizer(br.readLine());
		int start = stoi(st.nextToken());
		int dest = stoi(st.nextToken());

		dijkstra(start, dest);

		System.out.println(distance[dest]);

	}

	static void dijkstra(int start, int dest) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			int cur = pq.poll().idx;

			if (visited[cur])
				continue;
			visited[cur] = true;

			for (Node node : graph.get(cur)) {
				if (distance[node.idx] > distance[cur] + node.weight) {
					distance[node.idx] = distance[cur] + node.weight;
					pq.add(new Node(node.idx, distance[node.idx]));
				}
			}
		}

	}

	static void init() {
		graph = new ArrayList<>();
		distance = new int[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
