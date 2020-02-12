package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _17406 {
	/* 
	 * 배열 돌리기 4
	 */
	static int n, m, k, min = Integer.MAX_VALUE;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] origin;
	static int[][] copy;
	static int[] list;
	static boolean[] c;
	static List<Node> nodeList;

	static class Node {
		int r, c, s;

		public Node(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		k = stoi(st.nextToken());
		origin = new int[n + 1][m + 1];
		copy = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 1; j <= m; j++) {
				origin[i][j] = stoi(st.nextToken());
			}
		}

		nodeList = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(sc.nextLine());
			nodeList.add(new Node(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
		}

		list = new int[k];
		c = new boolean[k];
		permutation(0, 0);
		System.out.println(min);

	}

	private static void print() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------");
	}

	public static void rotate(int x, int y, int s) {
		for (int i = 1; i <= s; i++) {
			int sx = x - i;
			int sy = y - i;
			int value = copy[sx][sy];
			int dir = 0;

			while (dir < 4) {
				int nx = sx + dx[dir];
				int ny = sy + dy[dir];

				if (nx >= x - i && ny >= y - i && nx <= x + i && ny <= y + i) {
					copy[sx][sy] = copy[nx][ny];
					sx = nx;
					sy = ny;
				} else {
					dir++;
				}
			}
			copy[x - i][y - i + 1] = value;
		}
	}

	public static void simulation() {
		copyArray();
		for (int i : list) {
			rotate(nodeList.get(i).r, nodeList.get(i).c, nodeList.get(i).s);
		}
		min = Math.min(min, calc());
	}

	public static void permutation(int depth, int start) {
		if (depth == k) {
			simulation();
			return;
		}

		for (int i = 0; i < k; i++) {
			if (!c[i]) {
				c[i] = true;
				list[depth] = i;
				permutation(depth + 1, i + 1);
				c[i] = false;
			}
		}
	}

	public static int calc() {
		int result = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= m; j++) {
				sum += copy[i][j];
			}
			result = Math.min(result, sum);
		}

		return result;
	}

	public static void copyArray() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				copy[i][j] = origin[i][j];
			}
		}
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
