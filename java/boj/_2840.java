package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2840 {
	/* boj - 행운의 바퀴 */
	static int n, m;
	static StringTokenizer st;
	static char[] rotateArr;
	static int[] alpha;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		init();
		int curIndex, prevIndex = 0;
		char curChar;
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			prevIndex += stoi(st.nextToken());
			curIndex = prevIndex % n;
			curChar = st.nextToken().charAt(0);

			if (rotateArr[curIndex] != '?' && rotateArr[curIndex] != curChar) {
				flag = true;
			} else if (alpha[curChar - 'A'] != -1 && alpha[curChar - 'A'] != curIndex) {
				flag = true;
			} else {
				rotateArr[curIndex] = curChar;
				prevIndex = curIndex;
				alpha[curChar - 'A'] = curIndex;
			}

			if (i == m - 1) {
				if (flag) {
					System.out.println("!");
				} else {
					StringBuilder sb = new StringBuilder();
					for (int j = curIndex; j >= 0; j--) {
						sb.append(rotateArr[j]);
					}
					for (int x = rotateArr.length - 1; x > curIndex; x--) {
						sb.append(rotateArr[x]);
					}
					System.out.println(sb.toString());
				}
			}

		}

	}

	static void init() {
		rotateArr = new char[n];
		alpha = new int[26];
		Arrays.fill(rotateArr, '?');
		Arrays.fill(alpha, -1);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
