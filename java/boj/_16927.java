package boj;

import java.util.Scanner;

public class _16927 {
	/* 
	 * 배열 돌리기 2
	 */
	static int n, m, r;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int s = Math.min(n, m) / 2;

		int h = n;
		int w = m;
		for (int i = 0; i < s; i++) {
			int cnt = r % ((w + h) * 2 - 4);
			rotate(cnt, i);
			w -= 2;
			h -= 2;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

	static void rotate(int cnt, int s) {
		while (cnt-- > 0) {
			int dir = 0;
			int sx = s;
			int sy = s;
			int value = arr[sx][sy];
			while (dir < 4) {
				int nx = sx + dx[dir];
				int ny = sy + dy[dir];

				if (nx >= s && ny >= s && nx < n - s && ny < m - s) {
					arr[sx][sy] = arr[nx][ny];

					sx = nx;
					sy = ny;
				} else {
					dir++;
				}
			}
			arr[s + 1][s] = value;
		}
	}
}
