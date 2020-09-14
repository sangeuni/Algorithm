package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class _1238 {
	/* Boj - 파티 */
	static int V, E, X;
	static List<List<Node>> graph1, graph2;
	static int[] distance, go, back;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		X = stoi(st.nextToken());

		init();
		int u, v, w;
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			u = stoi(st.nextToken());
			v = stoi(st.nextToken());
			w = stoi(st.nextToken());

			graph1.get(u).add(new Node(v, w));
			graph2.get(v).add(new Node(u, w));
		}

		dijkstra(X, go, graph2);
		Arrays.fill(visited, false);
		dijkstra(X, back, graph1);
		int max = Integer.MIN_VALUE;
		int answer = 0;
		for (int i = 1; i <= V; i++) {
			if (max < go[i] + back[i]) {
				max = go[i] + back[i];
			}
		}
		System.out.println(max);
	}

	static int[] dijkstra(int start, int[] distance, List<List<Node>> graph) {
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

		return distance;
	}

	static void init() {
		graph1 = new ArrayList<List<Node>>();
		graph2 = new ArrayList<List<Node>>();
		distance = new int[V + 1];
		go = new int[V + 1];
		back = new int[V + 1];
		visited = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			graph1.add(new ArrayList<>());
			graph2.add(new ArrayList<>());
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
