package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _17142 {
	/* 
	 * 연구소 3
	 */
	static int n, m, min;
	static int[] a;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] map, copy, visited;
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

		map = new int[n][n];
		a = new int[m];
		virus = new ArrayList<>();

		int vCount = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = stoi(st.nextToken());
				if (map[i][j] == 1) {
					map[i][j] = -2;
				}
				if (map[i][j] == 2) {
					map[i][j] = -1;
					virus.add(new Node(i, j));
					vCount++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		permutation(0, 0, vCount);
		if(min == Integer.MAX_VALUE)
			min = -1;
		System.out.println(min);
	}

	static void permutation(int depth, int start, int size) {
		if (depth == m) {
			simulation();
			return;
		}

		for (int i = start; i < size; i++) {
			a[depth] = i;
			permutation(depth + 1, i + 1, size);
		}
	}

	static void simulation() {
		init();
		for (int i : a) {
			q.offer(virus.get(i));
			copy[virus.get(i).x][virus.get(i).y] = 0;
			visited[virus.get(i).x][virus.get(i).y] = 1;
		}
		bfs();
		int result = calc();
		if(result > -1)
			min = Math.min(min, result);
		print(copy);
		System.out.println(result);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (copy[nx][ny] == 0 && visited[nx][ny] == 0) {
					copy[nx][ny] = copy[cur.x][cur.y] + 1;
					q.offer(new Node(nx, ny));
					visited[nx][ny] = 1;
				}
				if (copy[nx][ny] == -1 && visited[nx][ny] == 0) {
					copy[nx][ny] = copy[cur.x][cur.y] + 1;
					q.offer(new Node(nx, ny));
					visited[nx][ny] = 1;
				}
			}
		}
	}

	static int calc() {
		int result = -1;
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(copy[i][j] < 0)
					continue;
				result = Math.max(result, copy[i][j]);
				if(copy[i][j] == 0 && visited[i][j] == 0) count++;
			}
		}
		
		if(count > 0) return -1;
		return result;
	}
	
	static void init() {
		visited = new int[n][n];
		copy = new int[n][n];
		q = new LinkedList<>();

		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n;j++) {
				copy[i][j] = map[i][j];
			}
		}
		
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}

	static void print(int[][] a) {
		for (int i = 0; i < n; i++) {
			for(int j = 0; j<n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static void print() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
