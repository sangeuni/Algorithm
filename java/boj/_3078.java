package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3078 {
	/* boj - 좋은 친구 */
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer>[] queues = new Queue[21];
		int n = stoi(st.nextToken());
		int k = stoi(st.nextToken());

		for (int i = 0; i < 21; i++) {
			queues[i] = new LinkedList<>();
		}

		long count = 0;
		for (int i = 0; i < n; i++) {
			int length = br.readLine().trim().length();

			if (queues[length].isEmpty()) {
				queues[length].offer(i);
			} else {
				while (i - queues[length].peek() > k) {
					queues[length].poll();
					if (queues[length].isEmpty()) {
						break;
					}
				}

				count += queues[length].size();
				queues[length].offer(i);
			}
		}

		System.out.println(count);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
