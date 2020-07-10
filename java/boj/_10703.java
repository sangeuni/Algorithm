package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class _10703 {
	/* boj - 유성 */
	static int r, c;
	static char[][] before, after;
	static LinkedList<Dot>[] meteor, ground;

	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		r = stoi(st.nextToken());
		c = stoi(st.nextToken());
		init();
		for (int i = 0; i < r; i++) {
			String s = in.readLine();
			for (int j = 0; j < c; j++) {
				before[i][j] = s.charAt(j);
				if (s.charAt(j) == 'X') {
					meteor[j].add(new Dot(i, j));
				} else if (s.charAt(j) == '#') {
					ground[j].add(new Dot(i, j));
				}
			}
		}
		int distance = Integer.MAX_VALUE;
		for (int i = 0; i < c; i++) {
			if (meteor[i].size() > 0) {
				distance = Math.min(ground[i].getFirst().x - meteor[i].getLast().x - 1, distance);
			}
		}

		copy();
		
		for (int i = 0; i < c; i++) {
			if (meteor[i].size() > 0) {
				move(i, distance);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < before.length; i++) {
			for (int j = 0; j < before[i].length; j++) {
				sb.append(after[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	static void move(int col, int distance) {
		for (int i = meteor[col].size() - 1; i >= 0; i--) {
			Dot dot = meteor[col].get(i);
			after[dot.x + distance][col] = 'X';
		}
	}

	static void copy() {
		for (int i = 0; i < before.length; i++) {
			for (int j = 0; j < before[i].length; j++) {
				if (before[i][j] != '#') {
					after[i][j] = '.';
				} else {
					after[i][j] = '#';
				}
			}
		}
	}

	static void init() {
		before = new char[r][c];
		after = new char[r][c];
		meteor = new LinkedList[c];
		ground = new LinkedList[c];
		for (int i = 0; i < c; i++) {
			meteor[i] = new LinkedList<>();
			ground[i] = new LinkedList<>();
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
