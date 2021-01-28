package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3109 {
    /*boj - 빵집*/
    static int r, c, answer;
    static int[][] map;
    static int[] d = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == '.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        answer = 0;
        for (int i = 0; i < r; i++) {
            if (dfs(i, 0)) answer++;
        }
        System.out.println(answer);
    }

    private static boolean dfs(int row, int col) {
        if (col == c - 1) {
            return true;
        }

        for (int j : d) {
            int nx = row + j;
            int ny = col + 1;

            if (isRange(nx, ny) && map[nx][ny] == 0) {
                map[nx][ny] = 1;
                if (dfs(nx, ny)) return true;
            }
        }
        return false;
    }

    private static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < r && ny < c;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
