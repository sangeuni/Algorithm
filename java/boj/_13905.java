package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _13905 {
   /* boj - 세부*/
    static int n, m, s, e, answer;
    static int[] parents;
    static PriorityQueue<Edge> pq;

    static class Edge implements Comparable<Edge> {
        private int from;
        private int to;
        private int d;

        public Edge(int from, int to, int d) {
            this.from = from;
            this.to = to;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return o.d - this.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        parents = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        s = stoi(st.nextToken());
        e = stoi(st.nextToken());


        pq = new PriorityQueue<>();
        int from, to, d;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = stoi(st.nextToken());
            to = stoi(st.nextToken());
            d = stoi(st.nextToken());

            pq.offer(new Edge(from, to, d));
        }

        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        answer = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);

                if (find(s) == find(e)) {
                    answer = edge.d;
                    break;
                }
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parents[b] = a;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
