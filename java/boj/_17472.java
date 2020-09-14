package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17472 {
	/* BOJ - 다리 만들기 2 */
	static int n, m;
	static int[][] map, visited;
	static int[] parent;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static PriorityQueue<Node> pq;

	static class Node implements Comparable<Node> {
		private int start;
		private int end;
		private int len;

		public Node(int start, int end, int len) {
			this.start = start;
			this.end = end;
			this.len = len;
		}

		@Override
		public int compareTo(Node o) {
			return this.len - o.len;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", len=" + len + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());

		visited = new int[n][m];
		map = new int[n][m];
		pq = new PriorityQueue<>();

		// input
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				if (stoi(st.nextToken()) == 1) {
					map[i][j] = -1;
				}
			}
		}

		// numbering
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0 && visited[i][j] == 0) {
					numbering(i, j, num++);
				}
			}
		}

		// map의 모든 cell에 대해 4방향으로 DFS
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int d = 0; d < 4; d++) {
					if (map[i][j] != 0) {
						init();
						visited[i][j] = 1;
						findLength(i, j, d, map[i][j]);
					}
				}
			}
		}

		parent = new int[num];
		for (int i = 1; i < num; i++) {
			parent[i] = -1;
		}

		System.out.println(kruskal(num));
	}

	static void numbering(int x, int y, int num) {
		if (map[x][y] == 0 || visited[x][y] == 1) {
			return;
		}
		map[x][y] = num;
		visited[x][y] = 1;
		int nx, ny;
		for (int i = 0; i < 4; i++) {
			nx = x + dx[i];
			ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;

			if (map[nx][ny] == -1 && visited[nx][ny] == 0) {
				numbering(nx, ny, num);
			}
		}

	}

	static void findLength(int x, int y, int dir, int label) {
		if (map[x][y] != 0 && map[x][y] != label) {
			pq.add(new Node(label, map[x][y], visited[x][y] - 2));
			return;
		}

		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx < 0 || ny < 0 || nx >= n || ny >= m)
			return;

		if (map[nx][ny] != label && visited[nx][ny] == 0) {
			visited[nx][ny] = visited[x][y] + 1;
			findLength(nx, ny, dir, label);
		}
	}

	static int kruskal(int num) {
		int result = 0;
		int count = 0;
		while (!pq.isEmpty() && count < num - 1) {
			Node node = pq.poll();
			// cycle 여부 확인 후 union

			if (node.len < 2)
				continue;

			if (union(node.start, node.end)) {
				result += node.len;
				count++;
			}
		}

		count = 0;
		for (int i : parent) {
			if (i == -1) {
				count++;
			}
		}

		return count == 1 ? result : -1;
	}

	static boolean union(int start, int end) {
		start = find(start);
		end = find(end);
		if (start != end) {
			parent[end] = start;
			return true;
		}
		return false;
	}

	static int find(int x) {
		if (parent[x] == -1) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void init() {
		for (int i = 0; i < visited.length; i++) {
			Arrays.fill(visited[i], 0);
		}
	}

	static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}
