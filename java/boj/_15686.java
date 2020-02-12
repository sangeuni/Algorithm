package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _15686 {
	/* 
	 * 치킨 배달
	 */
	static int n, m, min;
	static int[] a, temp;
	static List<Node> chicken;
	static List<Node> home;

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
		init();
		int count = 0;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(sc.nextLine());
			for (int j = 1; j <= n; j++) {
				int info = stoi(st.nextToken());
				if (info == 1) {
					home.add(new Node(i, j));
				} else if (info == 2) {
					chicken.add(new Node(i, j));
					count++;
				}
			}
		}
		min = Integer.MAX_VALUE;
		permutation(0, 0, count);
		System.out.println(min);

	}

	public static void simulation() {
		int sum = 0;
		for (int i = 0; i < home.size(); i++) {
			int pick = Integer.MAX_VALUE;
			for (int j = 0; j < a.length; j++) {
				int temp = Math.abs(home.get(i).x - chicken.get(a[j]).x)
						+ Math.abs(home.get(i).y - chicken.get(a[j]).y);
				pick = Math.min(pick, temp);
			}
			sum += pick;
		}
		min = Math.min(min, sum);
	}

	public static void permutation(int depth, int start, int size) {
		if (depth == m) {
			simulation();
			return;
		}
		for (int i = start; i < size; i++) {
			a[depth] = i;
			permutation(depth + 1, i + 1, size);
		}
	}

	public static void init() {
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		a = new int[m];
	}

	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
