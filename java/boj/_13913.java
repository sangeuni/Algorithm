package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class _13913 {
	/* 
	 * 숨바꼭질 4
	 */
	public static final int MAX = 100000;
	int n, k;
	int[] d;
	int[] visited;

	public void go() {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		d = new int[MAX + 1];
		visited = new int[MAX + 1];
		bfs(n);

		List<Integer> path = new LinkedList<>();
		int count = 0;
		int prev = d[k];
		path.add(k);
		if (prev != -1) {
			path.add(prev);
			while (true) {
				count++;
				if (d[prev] == -1) // 출발 위치까지 왔을 때
					break;
				prev = d[prev];
				path.add(prev);
			}
		}
		sb.append(count);
		sb.append('\n');
		for (int i = path.size() - 1; i >= 0; i--) {
			sb.append(path.get(i) + " ");
		}
		System.out.println(sb.toString());
	}

	public void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		d[n] = -1; // 출발 위치
		visited[n] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k) // 동생 찾으면 종료
				break;
			if (cur * 2 <= MAX && visited[cur * 2] == 0) { // 순간 이동
				d[cur * 2] = cur;
				visited[cur * 2] = 1;
				q.offer(cur * 2);
			}
			if (cur - 1 >= 0 && visited[cur - 1] == 0) { // 뒤로 걷기
				d[cur - 1] = cur;
				visited[cur - 1] = 1;
				q.offer(cur - 1);
			}
			if (cur + 1 <= MAX && visited[cur + 1] == 0) { // 앞으로 걷기
				d[cur + 1] = cur;
				visited[cur + 1] = 1;
				q.offer(cur + 1);
			}
		}
	}
}
