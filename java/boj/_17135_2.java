package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17135_2 {
	/* BOJ - 캐슬 디펜스 */
	static int n, m, d, answer;
	static int[] a;
	static int[][] map, copy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		d = stoi(st.nextToken());

		map = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}

		a = new int[3];
		permutation(0, 0);
		System.out.println(answer);
	}

	static void permutation(int start, int depth) {
		if (depth == 3) {
			init();
			for (int defence : a) {
				copy[n][defence] = 2;
			}
			solve();

			return;
		}

		for (int i = start; i < m; i++) {
			a[depth] = i;
			permutation(i + 1, depth + 1);
		}
	}

	static void solve() {
		int total = 0;
		for (int i = 0; i < n; i++) {
			total += shoot(i);
			update(i);
		}
		answer = Math.max(answer, total);
	}

	static void update(int row) {
		// 한 줄 씩 내리기
		for (int i = n - 2; i >= row; i--) {
			copy[i + 1] = copy[i].clone();
		}
		Arrays.fill(copy[row], 0);
	}

	static int shoot(int round) {
		// 각 궁수로부터 d 거리 안에 있는 적 죽이기
		loop: for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= d; j++) {
				// 1 ~ d
				for (int k = 1; k <= j; k++) {
					// map에서 벗어나지 않는지 체크 && 표적 방향이 적이라면
					if (n - k >= 0 && a[i] + (k - j) >= 0 && a[i] + (k - j) < m && copy[n - k][a[i] + (k - j)] >= 1) {
						copy[n - k][a[i] + (k - j)] += 1;
						continue loop;
					}
				}
				for (int k = j - 1, z = 1; k > 0; k--, z++) {
					if (n - k >= 0 && a[i] + z >= 0 && a[i] + z < m && copy[n - k][a[i] + z] >= 1) {
						copy[n - k][a[i] + z] += 1;
						continue loop;
					}
				}
			}
		}
		int count = 0;
		for(int i = 0; i<n; i++) {
			for(int  j = 0; j<m; j++) {
				if(copy[i][j] > 1) {
					count++;
					copy[i][j] = 0;
				}
			}
		}
		return count;
	}

	static void init() {
		copy = new int[n + 1][m];
		for (int i = 0; i < n; i++) {
			copy[i] = map[i].clone();
		}
	}

	static void print() {
		for (int i = 0; i < copy.length; i++) {
			for (int j = 0; j < copy[i].length; j++) {
				System.out.print(copy[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}
