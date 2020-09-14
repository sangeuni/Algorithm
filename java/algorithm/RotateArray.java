package algorithm;

import java.util.Scanner;

public class RotateArray {
	static int n, m, r, spin;
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		r = sc.nextInt();
		spin = r % (2 * (n + m) - 4);
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int sx = 0;
		int sy = 0;

		int w = n, h = m;
		while (w >= 2 && h >= 2) {
			rotateAntiClockwise(sx++, sy++, w, h);
			w -= 2;
			h -= 2;
		}
		print(arr);
		sx = 0; sy = 0; w = n; h = m;
		while (w >= 2 && h >= 2) {
			rotateClockwise(sx++, sy++, w, h);
			w -= 2;
			h -= 2;
		}
		print(arr);
	}

	// 반시계 방향 r칸 회전
	static void rotateAntiClockwise(int x, int y, int n, int m) {
		n = x + n;
		m = y + m;
		for (int i = 0; i < spin; i++) {
			int d = 0;
			int temp = arr[x][y];
			int cx = x;
			int cy = y;

			while (d < 4) {
				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx < x || ny < y || nx >= n || ny >= m) {
					d++;
					continue;
				}

				arr[cx][cy] = arr[nx][ny];
				cx = nx;
				cy = ny;
			}
			arr[x + 1][y] = temp;
		}
	}
	
	// 시계 방향 r칸 회전
	static void rotateClockwise(int x, int y, int n, int m) {
		n = x + n;
		m = y + m;
		for (int i = 0; i < spin; i++) {
			int d = 0;
			int temp = arr[x][y];
			int cx = x;
			int cy = y;

			while (d < 4) {
				int nx = cx + dy[d];
				int ny = cy + dx[d];

				if (nx < x || ny < y || nx >= n || ny >= m) {
					d++;
					continue;
				}

				arr[cx][cy] = arr[nx][ny];
				cx = nx;
				cy = ny;
			}
			arr[x][y+1] = temp;
		}
	}

	static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
