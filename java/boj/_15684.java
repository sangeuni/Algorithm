package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15684 {
	/* 사다리 조작 */
	static int R, m, C;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = stoi(st.nextToken()) * 2 + 1;
		m = stoi(st.nextToken());
		R = stoi(st.nextToken());

		map = new boolean[R + 1][C];

		int a, b;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			map[stoi(st.nextToken())][stoi(st.nextToken()) * 2] = true;
		}

		for (int i = 0; i <= R; i++) {
			for (int j = 1; j < C; j += 2) {
				map[i][j] = true;
			}
		}

		for (int i = 0; i < 4; i++) {
			if (permutation(i, 0)) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);

	}

	static boolean permutation(int depth, int count) {
		if (depth == count) {
			return draw();
		}
		for (int i = 1; i <= R; i++) {
			for (int j = 2; j < C - 1; j += 2) {
				if (!map[i][j - 2] && !map[i][j] && !map[i][j + 2]) {
					map[i][j] = true;
					if (permutation(depth, count + 1)) {
						return true;
					}
					map[i][j] = false;
				}
			}
		}
		return false;
	}

	static boolean draw() {
		for (int i = 1; i < C; i += 2) {
			int row = 0;
			int col = i;
			while (row != R + 1) {
				if (map[row][col - 1]) {
					row++;
					col -= 2;
				} else if (map[row][col + 1]) {
					row++;
					col += 2;
				} else {
					row++;
				}
			}
			if (i != col) {
				return false;
			}
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i <= R; i++) {
			for (int j = 1; j < C; j++) {
				if (j % 2 == 1) {
					if (map[i][j - 1]) {
						System.out.format("%c", '┤');
					} else if (map[i][j + 1]) {
						System.out.format("%c", '├');
					} else {
						System.out.format("%c", '│');
					}
				} else {
					if (map[i][j]) {
						System.out.format("%c", '─');
					} else {
						System.out.format("%c", ' ');
					}
				}
			}
			System.out.println();
		}
		System.out.println();

	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
