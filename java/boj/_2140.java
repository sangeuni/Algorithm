package boj;

import java.util.Scanner;

public class _2140 {
	/* 지뢰찾기 */
	int[][] map;
	int[] dx = { 1, -1, 0, 0, -1, -1, 1, 1 };
	int[] dy = { 0, 0, 1, -1, -1, 1, -1, 1 };
	int n, mine;

	class Dot {
		private int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		if (n <= 2) {
			System.out.println(0);
			return;
		}

		map = new int[n][n];
		sc.nextLine();
		
		// map 입력
		String str;
		for (int i = 0; i < n; i++) {
			str = sc.nextLine();
			for (int j = 0; j < n; j++) {
				try {
					map[i][j] = Character.getNumericValue(str.charAt(j));
				} catch (Exception e) {
					map[i][j] = -1;	// 지뢰는 -1로 입력
				}
			}
		}

		mine = (n - 2) * (n - 2);	// 가려진 곳에 모두 지뢰가 있다는 가정하에 시작
		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				search(new Dot(i, j));
			}
		}
		System.out.println(mine);

	}

	public void search(Dot dot) {
		if (checkZero(dot)) {
			mine--;		// '0'이 있다면 지뢰 개수 --
		} else {		// '0'이 없다면 8 방향의 값에 -1 해준다.
			int nx, ny;
			for (int i = 0; i < 8; i++) {
				nx = dot.x + dx[i];
				ny = dot.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;

				if (map[nx][ny] >= 0)	// 테두리만
					map[nx][ny]--;
			}
		}

	}

	// 8 방향에 '0'이 있는지 검사
	public boolean checkZero(Dot dot) {
		int nx, ny;
		for (int i = 0; i < 8; i++) {
			nx = dot.x + dx[i];
			ny = dot.y + dy[i];

			if (nx < 0 || ny < 0 || nx >= n || ny >= n)
				continue;

			if (map[nx][ny] == 0)
				return true;
		}
		return false;
	}
}
