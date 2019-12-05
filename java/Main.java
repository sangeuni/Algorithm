import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	int N, M;
	int[][] map;
	int[][] copy;
	int[][] visited;
	int[] dx = { 1, -1, 0, 0 };
	int[] dy = { 0, 0, 1, -1 };
	List<Dot> virusList;
	List<Dot> safetyList;
	int[] walls; // comArr[]
	int max = Integer.MIN_VALUE;

	class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void combination(int[] comArr, int n, int r, int idx, int target) {
		if (r == 0) {
			// 1. copy 만들어서 벽 세우기
			copy = new int[N][M];
			init();
			for (int i = 0; i < 3; i++) {
				Dot dot = safetyList.get(walls[i]);
				copy[dot.x][dot.y] = 1;
			}
			// 2. copy에 virus 뿌리기
			for (int i = 0; i < virusList.size(); i++) {
				bfs(virusList.get(i));
			}
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (copy[i][j] == 0)
						count++;
				}
			}
			if (count > max)
				max = count;
			return;
		} else if (n == target) {
			return;
		} else {
			walls[idx] = target;
			combination(comArr, n, r - 1, idx + 1, target + 1);
			combination(comArr, n, r, idx, target + 1);
		}

	}

	public void bfs(Dot dot) {
		Queue<Dot> q = new LinkedList<>();
		q.offer(dot);
		visited[dot.x][dot.y] = 1;

		while (!q.isEmpty()) {
			Dot cur = q.poll();
			int nx, ny;
			for (int i = 0; i < 4; i++) {
				nx = cur.x + dx[i];
				ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (copy[nx][ny] == 1||visited[nx][ny] == 1)
					continue;

				copy[nx][ny] = 2;
				q.offer(new Dot(nx, ny));
				visited[nx][ny] = 1;
			}
		}
	}

	public void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], 0);
		}
	}

	public void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		walls = new int[3];
		virusList = new LinkedList<>();
		safetyList = new LinkedList<>();
		int num;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				num = sc.nextInt();
				map[i][j] = num;
				if (num == 0)
					safetyList.add(new Dot(i, j));
				if (num == 2)
					virusList.add(new Dot(i, j));
			}
		}

		combination(walls, safetyList.size(), 3, 0, 0);
		print();
		System.out.println(max);
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.go();
	}
}