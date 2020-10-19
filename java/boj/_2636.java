package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2636 {
    /*boj - 치즈*/
    static int[][] map, visited;
    static int n, m, cheese, count, answer;
    static Queue<Dot> q;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Dot {
        private int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        map = new int[n][m];

        cheese = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        answer = 0;
        while (cheese > 0) {
            init();
            bfs(new Dot(0, 0));
            answer++;
        }

        System.out.println(answer);
        System.out.println(count);
    }

    static void bfs(Dot dot) {
        q = new LinkedList<>();
        q.offer(dot);
        visited[dot.x][dot.y] = 1;

        int temp = 0;
        while (!q.isEmpty()) {
            Dot cur = q.poll();
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] == 1) {
                    continue;
                }

                if (map[cur.x][cur.y] == 0) {
                    if (map[nx][ny] == 0) {
                        q.offer(new Dot(nx, ny));
                        visited[nx][ny] = 1;
                    }
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = 0;
                        visited[nx][ny] = 1;
                        cheese--;
                        temp++;
                    }
                }
            }
        }
        count = temp;
    }

    static void init() {
        visited = new int[n][m];
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
