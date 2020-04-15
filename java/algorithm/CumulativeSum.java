package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CumulativeSum {
	static int T, n, m, answer;
	static int[] arr, sumArr;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		n = stoi(st.nextToken());
		m = stoi(st.nextToken());
		init();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = stoi(st.nextToken());
			sumArr[i + 1] = sumArr[i] + arr[i];
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start, end;
			start = stoi(st.nextToken());
			end = stoi(st.nextToken());

			// s(end) - s(start);
			System.out.println(sumArr[end] - sumArr[start - 1]);
		}

	}

	static void init() {
		arr = new int[n];
		sumArr = new int[n + 1];
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
