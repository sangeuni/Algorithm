package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13460 {
	/* 
	 * 구슬 탈출 2
	 */
	static int n, m, answer;
	static char[][] map, copy;
	static int[] a = new int[10];
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static Node[] list = new Node[3];
	static Node[] copyList = new Node[3];

	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());

		map = new char[n][m];
		copy = new char[n][m];
		String s;
		for (int i = 0; i < n; i++) {
			s = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'R') {
					list[1] = new Node(i, j);
					continue;
				}
				if (map[i][j] == 'B') {
					list[2] = new Node(i, j);
					continue;
				}
				if (map[i][j] == 'O') {
					list[0] = new Node(i, j);
					continue;
				}

			}
		}
		answer = Integer.MAX_VALUE;
		permutation(0);
		if(answer == 100)
			answer = -1;
		System.out.println(answer);
	}

	static void permutation(int depth) {
		if (depth == 10) {
			copy();
			int result = simulation();
			answer = Math.min(answer, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			a[depth] = i;
			permutation(depth + 1);
		}
	}

	static int simulation() {
		int check = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < list.length; j++) {
				check += go(j % 2 + 1, a[i]);
			}
			
			if (check > 0 && check < 3) {
				return i+1;
			}else if(check >3) {
				return 100;
			}
		}
		return 100;
	}

	static int go(int index, int dir) {
		int x = copyList[index].x;
		int y = copyList[index].y;
		copy[x][y] = '.';

		while (true) {
			x += dx[dir];
			y += dy[dir];

			if (x > 0 && y > 0 && x < n - 1 && y < m - 1) {
				if (copy[x][y] == '.') {
					continue;
				} else if (copy[x][y] == 'O') {
					return index * index;
				}
			}
			break;
		}
		x -= dx[dir];
		y -= dy[dir];
		copyList[index] = new Node(x, y);

		if (index == 1) {
			copy[x][y] = 'R';
		} else {
			copy[x][y] = 'B';
		}
		return 0;
	}

	static void copy() {
		for (int i = 0; i < n; i++) {
		copy[i] = map[i].clone();
		}
		for(int i = 0; i<3; i++) {
			copyList[i] = list[i];
		}
	}

	static void print(char[][] a) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
