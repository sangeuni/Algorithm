package codingtest;

import java.io.IOException;

public class MineSweeper {
	static int R, C, X, Y;
	static char[][] map;
	static int[][] nums;
	static int[] dx = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, -1, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		 String[] input = { "EEEEE", "EEMEE", "EEEEE", "EEEEE" };
		// String[] result = solution(input, 2, 0);
		// String[] result = solution(input, 1, 2);
//		String[] input = { "EEEEMEEEE", "EEEEEEEEM", "EEEEEEMEE", "EEEEEEEEE", "EEMEEEEEM", "EEEEEEEEE", "MEEEEEMEE",
//				"EEEMEEEEE", "MEEEEEMEE" };
		String[] result = solution(input, 0, 0);
		for (String s : result) {
			System.out.println(s);
		}
	}

	private static String[] solution(String[] input, int x, int y) {
		init(input);
		// 시작점에 지뢰가 있을 경우, 시작점이 속한 Row만 복사해서 바꾸기
		if (map[x][y] == 'M') {
			map[x][y] = 'X';
			for (int i = 0; i < C; i++) {

				sb.append(map[x][i]);
			}
			input[x] = sb.toString();
			return input;
		}
		dfs(x, y); // flow.1 - 임의의 한 점 x, y 를 선택합니다.
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'M') {
					sb.append('E');
				} else {
					sb.append(map[i][j]);
				}
			}
			input[i] = sb.toString();
			sb = new StringBuilder();
		}
		return input;
	}

	private static void dfs(int x, int y) {
		int mine = 0;
		for (int i = 0; i < 8; i++) { // flow.2 - 주변의 8 곳을 살펴봅니다.
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if (map[nx][ny] == 'M') {
					mine++;
				}
			}
		}
		nums[x][y] = mine;

		map[x][y] = (char) (mine + '0');
		if (mine == 0) { // flow.3a - 지뢰가 없다면? -> 8 방향으로 dfs

			map[x][y] = 'B';

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C && nums[nx][ny] == -1) {
					dfs(nx, ny);
				}
			}
		} else { // flow.3b - 지뢰가 있다면? -> 함수 그냥 종료니까
		}
	}

	private static void init(String[] input) {
		R = input.length;
		C = input[0].length();
		map = new char[R][C];
		nums = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = input[i].charAt(j);
				nums[i][j] = -1;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
