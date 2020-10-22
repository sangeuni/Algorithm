package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _2665 {
    /*boj - 미로만들기*/
    static int n;
    static int[][] map, distance;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Dot> q;

    static class Dot {
        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());

        map = new int[n][n];
        distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        dijkstra(new Dot(0, 0));

        System.out.println(distance[n-1][n-1]);

    }

    static void dijkstra(Dot dot) {
        q = new LinkedList<>();
        q.add(dot);
        distance[dot.x][dot.y] = 0;

        while (!q.isEmpty()) {
            Dot cur = q.poll();
            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = cur.x + dir[i][0];
                ny = cur.y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (map[nx][ny] == 0) {
                    if (distance[nx][ny] > distance[cur.x][cur.y] + 1) {
                        distance[nx][ny] = distance[cur.x][cur.y] + 1;
                        q.offer(new Dot(nx,ny));
                    }
                } else {
                    if (distance[nx][ny] > distance[cur.x][cur.y]) {
                        distance[nx][ny] = distance[cur.x][cur.y];
                        q.offer(new Dot(nx,ny));
                    }
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
