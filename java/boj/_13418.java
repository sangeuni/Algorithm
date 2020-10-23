package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _13418 {
    /*boj - 학교 탐방하기*/
    static int n, m;
    static int[] parents;
    static Edge[] edges;

    static class Edge {
        private int x;
        private int y;
        private int d;

        public Edge(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        parents = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        st.nextToken();
        int init = stoi(st.nextToken());
        init = (init == 0) ? 1 : 0;

        edges = new Edge[m];
        int a, b, d;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = stoi(st.nextToken());
            b = stoi(st.nextToken());
            d = stoi(st.nextToken());
            d = (d == 0) ? 1 : 0;
            edges[i] = new Edge(a, b, d);
        }

        init();
        int min = kruskal(init, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.d - o2.d;
            }
        });

        init();
        int max = kruskal(init, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o2.d - o1.d;
            }
        });
        System.out.println(max * max - min * min);
    }

    private static int kruskal(int count, Comparator<Edge> comparator) {
        Arrays.sort(edges, comparator);
        for (int i = 0; i < edges.length; i++) {
            if (union(edges[i].x, edges[i].y)) {
                count += edges[i].d;
            }
        }
        return count;
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parents[y] = x;
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }


    private static void init() {
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        union(0, 1);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
