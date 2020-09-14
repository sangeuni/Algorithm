package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
	static int v,e,k;
	static List<List<Node>> graph;
	static int[] distance, prev;
	static boolean[] visited;
	
	static class Node implements Comparable<Node>{
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
	
	static void dijkstra(int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[k] = 0;
		pq.add(new Node(k,0));
		
		while(!pq.isEmpty()) {
			int cur = pq.poll().idx;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for (Node node : graph.get(cur)) {
				if (distance[node.idx] > distance[cur] + node.weight) {
					distance[node.idx] = distance[cur] + node.weight;
					prev[node.idx] = cur;
					pq.add(new Node(node.idx, distance[node.idx]));
				}
			}
		}
	}
	
	static void input(int v) {
		for(int i = 0; i<=v; i++) {
			graph.add(new ArrayList<>());
		}
		graph.get(1).add(new Node(2,3));
		graph.get(1).add(new Node(5,4));
		graph.get(1).add(new Node(4,4));
		graph.get(2).add(new Node(3,2));
		graph.get(3).add(new Node(4,1));
		graph.get(4).add(new Node(5,2));
		graph.get(5).add(new Node(6,4));
		graph.get(4).add(new Node(7,6));
		graph.get(7).add(new Node(6,3));
		graph.get(3).add(new Node(8,3));
		graph.get(6).add(new Node(8,2));
	}
	
	public static void main(String[] args) {
		v = 8; k = 1;
		graph = new ArrayList<List<Node>>();
		distance = new int[v+1];
		prev = new int[v+1];
		visited = new boolean[v+1];
		input(v);
		dijkstra(k);
		
		for(int i = 1; i<distance.length; i++) {
			System.out.print(distance[i] + " ");
		}
		System.out.println();
		for(int i = 1; i<distance.length; i++) {
			System.out.print(prev[i] + " ");
		}
	}
	
}
