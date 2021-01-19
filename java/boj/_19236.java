package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19236 {static int answer;
    /*boj - 청소년 상어*/
    static int[][] map;
    static Fish[] fish;
    // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};

    static class Fish {
        int x, y, dir;
        boolean died;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.died = false;
        }

        @Override
        public String toString() {
            return "[ " + this.x + " " + this.y + " " + this.dir + " ]";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[4][4];
        fish = new Fish[17];

        // input
        StringTokenizer st;
        int a, b;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                a = stoi(st.nextToken());
                b = stoi(st.nextToken());
                map[i][j] = a;
                fish[a] = new Fish(i, j, b);
            }
        }

        answer = Integer.MIN_VALUE;
        dfs(0, 0, map[0][0]);
        System.out.println(answer);
    }

    private static void dfs(int sx, int sy, int sum) {
        answer = Math.max(answer, sum);
        int[][] copyMap = new int[4][4];
        Fish[] copyFish = new Fish[17];

        // (1) 물고기 먹고, 상어 방향 반영
        int fishNum = map[sx][sy];
        int dir = fish[fishNum].dir;
        fish[fishNum].died = true;
        map[sx][sy] = -1;

        // (2) 물고기 move
        move(map, fish);

        // (*) 상어 이동 전 map copy
        copy(copyMap, copyFish);

        // (3) 상어 이동
        int nx, ny;
        for (int i = 1; i < 4; i++) { // for ( 상어가 이동할 수 있는 칸에 대해)
            nx = sx + (i * dx[dir]);
            ny = sy + (i * dy[dir]);

            // map 벗어나거나 빈 칸인지
            if (isInvalid(nx, ny))
                break;
            if (map[nx][ny] == 0) continue;

            // (**) 상어 위치는 빈 칸으로 업데이트
            map[sx][sy] = 0;

            // 사냥
            dfs(nx, ny, sum + map[nx][ny]);

            // (*) 상태로 돌아감, 상어가 어떤 칸으로도 이동하지 않은 상태로 다시 복구
            revertMap(copyMap, copyFish);

            // (**) 상어 위치 복구
            map[sx][sy] = -1;
        }
    }

    private static boolean isInvalid(int nx, int ny) {
        return nx < 0 || ny < 0 || nx >= 4 || ny >= 4;
    }

    private static void revertMap(int[][] copyMap, Fish[] copyFish) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = copyMap[i][j];
            }
        }

        for (int i = 1; i < copyFish.length; i++) {
            fish[i].x = copyFish[i].x;
            fish[i].y = copyFish[i].y;
            fish[i].dir = copyFish[i].dir;
            fish[i].died = copyFish[i].died;
        }
    }

    private static void copy(int[][] copyMap, Fish[] copyFish) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (int i = 1; i < copyFish.length; i++) {
            copyFish[i] = new Fish(0, 0, 0);
            copyFish[i].x = fish[i].x;
            copyFish[i].y = fish[i].y;
            copyFish[i].dir = fish[i].dir;
            copyFish[i].died = fish[i].died;
        }
    }

    private static int[][] move(int[][] map, Fish[] fish) {
        for (int i = 1; i < fish.length; i++) {
            if (fish[i].died) continue;
            int nx, ny, cx, cy;
            cx = fish[i].x;
            cy = fish[i].y;

            // 초기 방향
            int dir = fish[i].dir;
            while (true) {
                nx = cx + dx[fish[i].dir];
                ny = cy + dy[fish[i].dir];

                // 범위 벗어나거나 상어 있으면 반시계방향 변경
                // ↑, ↖, ←, ↙, ↓, ↘, →, ↗
                if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || map[nx][ny] == -1) {
                    if (fish[i].dir + 1 > 8) {
                        fish[i].dir = 1;
                    } else {
                        fish[i].dir++;
                    }
                    if (dir == fish[i].dir) break;
                } else {
                    // 0이면 그냥 이동
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = i;
                        map[cx][cy] = 0;

                        fish[i].x = nx;
                        fish[i].y = ny;
                    }
                    // 이동칸에 물고기가 있으면 trade
                    else {
                        int n = map[nx][ny];
                        map[nx][ny] = i;
                        map[cx][cy] = n;

                        int tx = fish[n].x;
                        int ty = fish[n].y;
                        fish[n].x = fish[i].x;
                        fish[n].y = fish[i].y;
                        fish[i].x = tx;
                        fish[i].y = ty;
                    }
                    break;
                }
            }
        }
        return map;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
