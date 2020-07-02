package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _2784 {
	/* boj - 가로 세로 퍼즐 */
	static String[] words, temp;
	static int[] arr;
	static boolean[] c;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		words = new String[6];
		temp = new String[6];
		arr = new int[6];
		c = new boolean[6];
		list = new LinkedList<>();

		for (int i = 0; i < 6; i++) {
			words[i] = br.readLine();
		}

		Arrays.sort(words);

		permutation(0);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();

		if (list.size() > 0) {
			for (int i = 1; i <= 9; i++) {
				sb.append(list.get(0).charAt(i - 1));
				if (i % 3 == 0) {
					sb.append('\n');
				}
			}
			System.out.println(sb.toString());
		} else {
			System.out.println(0);
		}
	}

	static boolean check() {
		for (int i = 0; i < 6; i++) {
			temp[i] = words[arr[i]];
		}

		StringBuilder sb;
		for (int i = 0; i < 3; i++) {
			sb = new StringBuilder();
			for (int j = 0; j < 3; j++) {
				sb.append(temp[3 + j].charAt(i));
			}
			if (!temp[i].equals(sb.toString()))
				return false;
		}
		return true;
	}

	static void permutation(int count) {
		if (count >= 6) {
			if (check()) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 3; i++) {
					sb.append(words[arr[i]]);
				}
				list.add(sb.toString());
			}
			return;
		}

		for (int i = 0; i < 6; i++) {
			if (c[i])
				continue;
			arr[count] = i;
			c[i] = true;
			permutation(count + 1);
			c[i] = false;
		}
	}
}
