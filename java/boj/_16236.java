package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _16236 {
    /*boj - 아기 상어*/
    static int n, curSize, answer, count, total;
    static Dot start;
    static Dot[][] visited;
    static int[][] map;
    static List<Dot> fishes;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Dot implements Comparable<Dot> {
        private int x;
        private int y;
        private int step;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
            this.step = 0;
        }

        // 물고기 우선순위에 따라 정렬 (거리 > x좌표 > y좌표)
        @Override
        public int compareTo(Dot o) {
            return this.step < o.step ? -1 : this.step == o.step ? this.x < o.x ? -1 : this.x == o.x ? this.y - o.y : 1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = stoi(br.readLine());
        map = new int[n][n];

        fishes = new ArrayList<>();

        // input
        start = null;
        total = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 9) {
                    // 시작 상어 위치
                    start = new Dot(i, j);
                    map[i][j] = 0;
                } else if (map[i][j] != 0) {
                    // 물고기 수 count
                    total++;
                }
            }
        }

        // 상어 초기 size;
        curSize = 2;
        answer = 0;
        count = 0;
        while (total > 0) {
            init();
            bfs(start);
            Collections.sort(fishes);
            if (fishes.size() > 0) {
                Dot fish = fishes.get(0);
                answer += (fish.step - 1);
                map[fish.x][fish.y] = 0;
                start = new Dot(fish.x, fish.y);
                count++;
                total--;
                if (count == curSize) {
                    count = 0;
                    curSize++;
                }
            } else {
                break;
            }

        }
        System.out.println(answer);
    }

    private static void bfs(Dot dot) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(dot);
        visited[dot.x][dot.y].step = 1;

        while (!q.isEmpty()) {
            Dot cur = q.poll();

            int nx, ny;
            for (int i = 0; i < 4; i++) {
                nx = dx[i] + cur.x;
                ny = dy[i] + cur.y;

                if (nx < 0 || ny < 0 || nx >= n || ny >= n)
                    continue;
                if (map[nx][ny] > curSize || visited[nx][ny].step > 0)
                    continue;

                visited[nx][ny].step = visited[cur.x][cur.y].step + 1;
                q.offer(visited[nx][ny]);
                if (map[nx][ny] != 0 && map[nx][ny] < curSize) {
                    fishes.add(visited[nx][ny]);
                }
            }
        }
    }


    private static void init() {
        fishes.clear();
        visited = new Dot[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = new Dot(i, j);
            }
        }
    }

    private static void print(int[][] map) {
        for (int[] ints : map) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
