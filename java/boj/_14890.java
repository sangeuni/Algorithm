package boj;

import java.util.Scanner;

public class _14890 {
	/*
	 * 경사로
	 * - 시뮬레이션
	 */
	int[][] map;
	int n, l;

	public void go() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		l = sc.nextInt();

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();

			}
		}
		int answer = 0;
		// row
		for (int i = 0; i < n; i++) {
			if (check(map[i]))
				answer++;
		}

		// column
		for (int i = 0; i < n; i++) {
			int[] a = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = map[j][i];
			}
			if (check(a))
				answer++;
		}
		System.out.println(answer);
	}

	public boolean check(int[] a) {
		boolean[] flag = new boolean[n];
		for (int i = 1; i < n; i++) {
			if (a[i - 1] == a[i])
				continue;

			// 높이 차이가 1 넘는지
			int diff = Math.abs(a[i - 1] - a[i]);

			if (diff > 1)
				return false;

			if (a[i - 1] < a[i]) {
				for (int j = 1; j <= l; j++) {
					// 범위 체크
					if (i - j < 0)
						return false;
					// 경사로 설치 여부 확인
					if (flag[i - j])
						return false;
					// 높이 같은지
					if (a[i - 1] != a[i - j])
						return false;
					flag[i - j] = true;
				}
			} // a[i]를 기준으로 왼쪽 경사로
			else {
				for (int j = 0; j < l; j++) {
					if (i + j >= n)
						return false;
					if (flag[i + j])
						return false;
					if (a[i] != a[i + j])
						return false;
					flag[i + j] = true;
				}
			} // a[i]를 기준으로 오른쪽 경사로
		}

		return true;
	}
}
