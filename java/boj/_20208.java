package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _20208 {
   /* boj - 진우의 민트초코우유*/
    static int n, m, h, answer = 0;
    static int[][] map;
    static int[] pick;
    static boolean[] c;
    static Node home;
    static List<Node> minchos;

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        h = stoi(st.nextToken());

        map = new int[n][n];
        minchos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = stoi(st.nextToken());
                if (map[i][j] == 1) {
                    home = new Node(i, j);
                } else if (map[i][j] == 2) {
                    minchos.add(new Node(i, j));
                }
            }
        }

        pick = new int[minchos.size()];
        c = new boolean[minchos.size()];
        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int depth) {
        if (depth > answer) {
            simulation(depth);
        }
        if (depth < minchos.size()) {
            for (int i = 0; i < minchos.size(); i++) {
                if (!c[i]) {
                    c[i] = true;
                    pick[depth] = i;
                    permutation(depth + 1);
                    c[i] = false;
                }
            }
        }
    }

    private static void simulation(int count) {
        int cur = m;
        int x = home.x;
        int y = home.y;
        for (int i = 0; i < count; i++) {
            Node mincho = minchos.get(pick[i]);
            int d = Math.abs(x - mincho.x) + Math.abs(y - mincho.y);
            if (d <= cur) {
                cur -= d;
                cur += h;
                x = mincho.x;
                y = mincho.y;
            } else {
                return;
            }
        }

        if (Math.abs(x - home.x) + Math.abs(y - home.y) <= cur) {
            answer = Math.max(answer, count);
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
