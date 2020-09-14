package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1753 {
	/* boj - 최단경로 */
	static int V, E, K;
	static List<List<Node>> graph;
	static int[] distance;
	static boolean[] visited;
	static StringTokenizer st;

	static class Node implements Comparable<Node> {
		private int idx, weight;

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
		// input
		st = new StringTokenizer(br.readLine());
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		K = stoi(br.readLine());

		init();

		// input
		int from, to, weight;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = stoi(st.nextToken());
			to = stoi(st.nextToken());
			weight = stoi(st.nextToken());

			graph.get(from).add(new Node(to, weight));
		}

		dijkstra();

		// print
		for (int i = 1; i <= V; i++) {
			System.out.println((distance[i] == Integer.MAX_VALUE) ? "INF" : distance[i]);
		}
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[K] = 0;
		pq.add(new Node(K, 0));

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
		graph = new ArrayList<List<Node>>();
		distance = new int[V + 1];
		visited = new boolean[V + 1];

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
