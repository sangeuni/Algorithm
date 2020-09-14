package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _16637 {
	/* BOJ - 괄호 추가하기 */
	static int n, max;
	static char origin[];
	static int copy[];
	static List<Integer> priority;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());

		origin = br.readLine().toCharArray();
		priority = new ArrayList<>();

		max = solve();
		permutation(0, 1);
		System.out.println(max);
	}

	static void permutation(int depth, int start) {
		for (int i = start; i < n; i += 2) {
			priority.add(i);
			max = Math.max(max, solve());
			permutation(depth + 1, i + 4);
			priority.remove(depth);
		}
	}

	static int solve() {
		copyExpression();
		for (int i : priority) {
			calc(i, origin[i]);
		}
		return calc();
	}

	static int calc() {
		int result = copy[0];
		for (int i = 1; i < n; i += 2) {
			if (copy[i] < 0)
				continue;
			switch (origin[i]) {
			case '+':
				result += copy[i+1];
				break;
			case '-':
				result -= copy[i+1];
				break;
			case '*':
				result *= copy[i+1];
				break;
			}
		}
		return result;
	}

	static void calc(int idx, char op) {
		switch (op) {
		case '+':
			copy[idx - 1] += copy[idx + 1];
			copy[idx] = -1;
			break;
		case '-':
			copy[idx - 1] -= copy[idx + 1];
			copy[idx] = -1;
			break;
		case '*':
			copy[idx - 1] *= copy[idx + 1];
			copy[idx] = -1;
			break;
		}
	}

	static void copyExpression() {
		copy = new int[n];
		for (int i = 0; i < n; i++) {
			if (Character.isDigit(origin[i])) {
				copy[i] = origin[i] - '0';
			}
		}
	}
}
