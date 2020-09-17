package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _17136 {
    /* BOJ - 색종이 붙이기 */
    static final int INF = Integer.MAX_VALUE;
    static int answer;
    static int[][] map;
    static int[] paper;

    static class Dot {
        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[10][10];
        paper = new int[6];
        Arrays.fill(paper, 5);
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = Integer.MAX_VALUE;
        backtracking(0);
        System.out.println(answer == INF ? -1 : answer);
    }

    private static void backtracking(int num) {
        Dot dot = findDot();

        if (dot.x == -1 || dot.y == -1) {
            answer = Math.min(answer, num);
            return;
        }

        for (int size = 1; size <= 5; size++) {
            if (paper[size] == 0) {
                continue;
            }

            if (isPossible(dot, size)) {
                for (int i = dot.x; i < dot.x + size; i++) {
                    for (int j = dot.y; j < dot.y + size; j++) {
                        map[i][j] = 2;
                    }
                }

                paper[size]--;
                backtracking(num + 1);
                paper[size]++;

                for (int i = dot.x; i < dot.x + size; i++) {
                    for (int j = dot.y; j < dot.y + size; j++) {
                        map[i][j] = 1;
                    }
                }
            } else {
                break;
            }
        }
    }

    private static boolean isPossible(Dot dot, int size) {
        for (int i = dot.x; i < dot.x + size; i++) {
            for (int j = dot.y; j < dot.y + size; j++) {
                if (i < 0 || j < 0 || i >= 10 || j >= 10 || map[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Dot findDot() {
        Dot dot = new Dot(-1, -1);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (map[i][j] == 1) {
                    dot.x = i;
                    dot.y = j;
                    return dot;
                }
            }
        }
        return dot;
    }
}
