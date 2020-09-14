package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class _10282 {	
	/* BOJ - 해킹 */
	static int n,d,c;
	static int[] distance;
	static boolean[] visited;
	static List<List<Node>> network;
	
	static class Node implements Comparable<Node>{
		private int num;
		private int time;
		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}
		@Override
		public int compareTo(Node o) {
			return this.time - o.time;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = stoi(br.readLine());
		for(int t = 0; t<tc; t++) {
			st = new StringTokenizer(br.readLine());
			n = stoi(st.nextToken());
			d = stoi(st.nextToken());
			c = stoi(st.nextToken());
			init();
			
			int a, b, s;
			for(int i = 0; i<d; i++) {
				st = new StringTokenizer(br.readLine());
				a = stoi(st.nextToken());
				b = stoi(st.nextToken());
				s = stoi(st.nextToken());
				
				network.get(b).add(new Node(a,s));
			}
			dijkstra(c);
			int count = 0, time = 0;
			for(int i = 1; i<distance.length; i++) {
				if(distance[i] != Integer.MAX_VALUE) {
					count++;
					time = Math.max(time, distance[i]);
				}
			}
			
			System.out.println(count + " " + time);
		}
	}
	
	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			int cur = pq.poll().num;
			
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for(Node node : network.get(cur)) {
				if(distance[node.num] >distance[cur] + node.time) {
					distance[node.num] = distance[cur] + node.time;
					pq.add(new Node(node.num, distance[node.num]));
				}
			}
		}
	}
	
	static void init() {
		distance = new int[n+1];
		visited = new boolean[n+1];
		network = new ArrayList<List<Node>>();
		for(int i = 0; i<=n; i++) {
			network.add(new ArrayList<>());
		}
	}
	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
