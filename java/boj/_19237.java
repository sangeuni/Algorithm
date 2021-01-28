package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _19237 {
    /* boj - 어른 상어 */
    static int n, m, k, time, count;
    static Smell[][] map;
    static Shark[] sharks;
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};

    static class Shark {
        private int x;
        private int y;
        private int dir;
        private boolean kill;
        private String[] dirArray;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.kill = false;
            this.dirArray = new String[5];
        }

        public void setDirArray(int d, String dirString) {
            this.dirArray[d] = dirString;
        }
    }

    static class Smell {
        private int num;
        private int time;
        private List<Integer> shark;

        public Smell(int num, int time) {
            this.num = num;
            this.time = time;
            this.shark = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        k = stoi(st.nextToken());

        map = new Smell[n][n];
        sharks = new Shark[m + 1];

        // input map
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = stoi(st.nextToken());
                if (num > 0) {
                    sharks[num] = new Shark(i, j);
                    map[i][j] = new Smell(num, k);
                    map[i][j].shark.add(num);
                } else {
                    map[i][j] = new Smell(0, 0);
                }
            }
        }

        // 상어 초기 방향 설정
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= m; i++) {
            sharks[i].dir = stoi(st.nextToken());
        }


        // 상어 우선순위 방향 설정
        StringBuilder sb;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                sb = new StringBuilder();
                sb.append(0);
                for (int l = 0; l < 4; l++) {
                    sb.append(st.nextToken());
                }
                sharks[i].setDirArray(j, sb.toString());
            }
        }

        time = 0;
        count = m;

        while (count > 1 && time++ < 1000) {
            // 상어 이동
            for (int i = m; i >= 1; i--) {
                if (!sharks[i].kill) {
                    // 이동 못했을 때
                    if (!moveShark(i)) {
                        // 자기 번호로 돌아가기
                        moveBack(i);
                    }
                }
            }
            updateMap();
        }
        System.out.println(time > 1000 ? -1 : time);
    }


    private static void moveBack(int num) {
        int dir, sx, sy, nx, ny;
        sx = sharks[num].x;
        sy = sharks[num].y;
        for (int i = 1; i <= 4; i++) {
            dir = sharks[num].dirArray[sharks[num].dir].charAt(i) - '0';
            nx = sx + dx[dir];
            ny = sy + dy[dir];

            if (!isRange(nx, ny)) continue;

            // 내가 있던 자리라면
            if (map[nx][ny].num == num) {
                map[sx][sy].time = k;
                map[sx][sy].shark.clear();

                map[nx][ny].time = k;
                map[nx][ny].shark.add(num);
                sharks[num].dir = dir;
                break;
            }
        }
    }

    private static boolean moveShark(int num) {
        int dir, sx, sy, nx, ny;
        sx = sharks[num].x;
        sy = sharks[num].y;

        for (int i = 1; i <= 4; i++) {
            dir = sharks[num].dirArray[sharks[num].dir].charAt(i) - '0';
            nx = sx + dx[dir];
            ny = sy + dy[dir];

            if (!isRange(nx, ny)) continue;

            // no 냄새
            if (map[nx][ny].num == 0) {
                if(map[nx][ny].shark.size() > 0){
                    sharks[map[nx][ny].shark.get(0)].kill = true;
                    map[nx][ny].shark.clear();
                    count--;
                }

                // 원래 있던 자리 update
                map[sx][sy].shark.remove(Integer.valueOf(num));
                map[nx][ny].shark.add(num);

                // 상어 방향 update
                sharks[num].dir = dir;
                return true;
            }
        }
        return false;
    }

    private static void updateMap() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 상어가 있는 칸
                if (map[i][j].shark.size() == 1) {
                    int num = map[i][j].shark.get(0);
                    map[i][j].num = num;
                    map[i][j].time = k;
                    sharks[num].x = i;
                    sharks[num].y = j;
                }
                // 냄새 남아있는 칸
                else if (map[i][j].num > 0 && map[i][j].shark.size() == 0) {
                    if (map[i][j].time == 1) {
                        map[i][j] = new Smell(0, 0);
                    } else {
                        map[i][j].time--;
                    }
                }
            }
        }
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
