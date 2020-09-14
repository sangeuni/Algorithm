package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RotateArray2 {
	static int n, m, r;	// n, m은 짝수
	static int[][] arr;
	static List<Integer> opList;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		r = stoi(st.nextToken());

		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}

		opList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < r; i++) {
			switch (stoi(st.nextToken())) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			default:
				break;
			}
		}
		
		print(arr);
		bw.flush();
		bw.close();
	}

	// 상하 반전
	static void one() {
		for (int i = 1; i <= arr.length / 2; i++) {
			int[] temp = arr[i];
			arr[i] = arr[arr.length - i];
			arr[arr.length - i] = temp;
		}
	}

	// 좌우 반전
	static void two() {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= arr[i].length / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - j];
				arr[i][arr[i].length - j] = temp;
			}
		}
	}

	// 시계 방향 90도 회전
	static void three() {
		int[][] temp = copy(arr);
		n = temp.length -1;
		m = temp[0].length - 1;
		arr = new int[m+1][n+1];
		for (int i = 1, j = n; j >= 1; j--, i++) {
			for (int k = 1; k <= m; k++) {
				arr[k][j] = temp[i][k];
			}
		}
	}

	// 반시계 방향 90도 회전
	static void four() {
		int[][] temp = copy(arr);
		n = temp.length -1;
		m = temp[0].length - 1;
		arr = new int[m+1][n+1];
		for (int i = 1, j = 1; j <= n; j++, i++) {
			for (int k = 1; k <= m; k++) {
				arr[k][j] = temp[i][m - k + 1];
			}
		}
	}

	// 시계 방향 그룹 이동
	static void five() {
		int[][] temp = copy(arr);
		n = temp.length-1;
		m = temp[0].length-1;
		// 1 -> 2
		for (int j = 1; j <= n / 2; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j][m / 2 + i] = temp[j][i];
			}
		}
		// 3 -> 4
		for (int j = n / 2 + 1; j <= n; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j][i - m / 2] = temp[j][i];
			}
		}

		// 2 -> 3
		for (int j = 1; j <= n / 2; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j + n / 2][i] = temp[j][i];
			}
		}

		// 4 -> 1
		for (int j = n / 2 + 1; j <= n; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j - n / 2][i] = temp[j][i];
			}
		}
	}

	// 반시계 방향 그룹 이동
	static void six() {
		int[][] temp = copy(arr);
		n = temp.length-1;
		m = temp[0].length-1;
		// 1 -> 4
		for (int j = 1; j <= n / 2; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j + n / 2][i] = temp[j][i];
			}
		}
		// 4 -> 3
		for (int j = n / 2; j <= n; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j][m / 2 + i] = temp[j][i];
			}
		}
		// 3 -> 2
		for (int j = n / 2 + 1; j <= n; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j - n / 2][i] = temp[j][i];
			}
		}
		// 2 -> 1
		for (int j = 1; j <= n / 2; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j][i - m / 2] = temp[j][i];
			}
		}
	}

	static int[][] copy(int[][] arr) {
		int[][] temp = new int[arr.length][arr[0].length];
		for (int i = 1; i <= arr.length-1; i++) {
			for (int j = 1; j <= arr[0].length-1; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

	static void print(int arr[][]) throws IOException {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				bw.append(arr[i][j] + " ");
			}
			bw.newLine();
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
