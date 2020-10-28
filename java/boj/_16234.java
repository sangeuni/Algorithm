package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16234 {
    static int n, size, L, R;
    static int[][] map, copy, visited;
    static int[][] dir1 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] dir2 = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
    static List<Dot> unitedList;

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
        L = stoi(st.nextToken());
        R = stoi(st.nextToken());

        size = n + (n - 1);
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            Arrays.fill(map[i], -1);
        }

        for (int i = 0; i < size; i += 2) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j += 2) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        int count, answer = 0;
        while (true) {
            count = 0;
            init();
            int nx, ny;
            for (int i = 0; i < size; i += 2) {
                for (int j = 0; j < size; j += 2) {
                    for (int k = 0; k < 4; k++) {
                        nx = i + dir2[k][0];
                        ny = j + dir2[k][1];

                        if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                            int sub = Math.abs(map[i][j] - map[nx][ny]);
                            if (sub >= L && sub <= R) {
                                copy[i + dir1[k][0]][j + dir1[k][1]] = 0;
                                count++;
                            }
                        }
                    }
                }
            }

            if (count == 0) {
                break;
            }
            visited = new int[size][size];
            for (int i = 0; i < size; i += 2) {
                for (int j = 0; j < size; j += 2) {
                    if (visited[i][j] == 0) {
                        bfs(new Dot(i, j));
                    }
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    private static void bfs(Dot dot) {
        Queue<Dot> q = new LinkedList<>();
        unitedList = new ArrayList<>();
        q.offer(dot);
        visited[dot.x][dot.y] = 1;
        unitedList.add(dot);

        int sum = 0;
        int count = 1;
        while (!q.isEmpty()) {
            Dot cur = q.poll();
            sum += copy[cur.x][cur.y];

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = dir1[i][0] + cur.x;
                ny = dir1[i][1] + cur.y;

                if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
                    if (visited[nx][ny] == 0 && copy[nx][ny] != -1) {
                        if (copy[nx][ny] > 0) {
                            unitedList.add(new Dot(nx, ny));
                            count++;
                        }
                        visited[nx][ny] = 1;

                        q.offer(new Dot(nx, ny));
                    }
                }
            }
        }
        update(sum / count);
    }

    private static void update(int count) {
        for (Dot dot : unitedList) {
            map[dot.x][dot.y] = count;
        }
    }

    private static void init() {
        copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            copy[i] = map[i].clone();
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
