package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _4386 {
    /*boj - 별자리 만들기*/
    static int n;
    static Dot[] dots;
    static int[] parents;

    static class Dot {
        private int idx;
        private double x;
        private double y;

        public Dot(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        private Dot dot1, dot2;
        private double d;

        public Edge(Dot dot1, Dot dot2, double d) {
            this.dot1 = dot1;
            this.dot2 = dot2;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());

        dots = new Dot[n];
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }


        StringTokenizer st;
        double x, y;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());

            dots[i] = new Dot(i, x, y);
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n; j++) {
                pq.offer(new Edge(dots[i], dots[j], getDistance(dots[i].x, dots[j].x, dots[i].y, dots[j].y)));
            }
        }
        double answer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            if (count == n - 1) break;
            Edge edge = pq.poll();
            if (union(edge.dot1.idx, edge.dot2.idx)) {
                count++;
                answer += Double.parseDouble(String.format("%.2f", edge.d));
            }
        }

        System.out.println(answer);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parents[b] = a;
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

    private static double getDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
