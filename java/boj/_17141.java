package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class _17141 {
	/* 
	 * 연구소 2
	 */
	static int n, m, min;
	static int[] a;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] origin, copy, visited;
	static List<Node> virus;
	static Queue<Node> q;

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());

		origin = new int[n][n];
		copy = new int[n][n];
		virus = new ArrayList<>();
		a = new int[m];
		
		int zero = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				origin[i][j] = stoi(st.nextToken());
				if (origin[i][j] == 0) {
					zero++;
				}
				if (origin[i][j] == 2) {
					virus.add(new Node(i, j));
					origin[i][j] = 0;
					count++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		permutation(0, 0, count);
		if(min == Integer.MAX_VALUE)
			min = -1;
		if(zero == 0 && count == m)
			min = 0;
		System.out.println(min);
	}

	public static void simulation() {
		copy();
		for (int i : a) {
			Node node = virus.get(i);
			q.offer(node);
			visited[node.x][node.y] = 1;
		}
		bfs();
		//print();
		int result = calc();
		if(result > -1) min = Math.min(min, result);
	}

	public static int calc() {
		int zero = 0;
		int result = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copy[i][j] == 0)
					zero++;
				result = Math.max(result, copy[i][j]);
			}
		}
		if (zero > m)
			return -1;
		return result;
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (copy[nx][ny] == 1 || visited[nx][ny] == 1)
					continue;

				copy[nx][ny] = copy[cur.x][cur.y] + 1;
				q.offer(new Node(nx, ny));
				visited[nx][ny] = 1;
			}
		}
	}

	public static void permutation(int depth, int start, int count) {
		if (depth == m) {
			init();
			simulation();
			return;
		}

		for (int i = start; i < count; i++) {
			a[depth] = i;
			permutation(depth + 1, i + 1, count);
		}
	}

	public static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}

	public static void init() {
		visited = new int[n][n];
		q = new LinkedList<>();
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
