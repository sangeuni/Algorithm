package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _9373 {
   /* boj - 복도 뚫기*/
    static int w, n;
    static int[] parents, x, y, r;

    static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private double d;

        public Edge(int start, int end, double d) {
            this.start = start;
            this.end = end;
            this.d = d;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.d, o.d);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());

        for (int t = 0; t < tc; t++) {
            w = stoi(br.readLine());
            n = stoi(br.readLine());

            parents = new int[n + 2];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            x = new int[n];
            y = new int[n];
            r = new int[n];

            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x[i] = stoi(st.nextToken());
                y[i] = stoi(st.nextToken());
                r[i] = stoi(st.nextToken());
            }

            PriorityQueue<Edge> pq = new PriorityQueue<>();
            pq.add(new Edge(n, n + 1, w));
            for (int i = 0; i < n; i++) {
                pq.add(new Edge(i, n, Math.max(0, x[i] - r[i])));
                pq.add(new Edge(i, n + 1, Math.max(0, w - x[i] - r[i])));

                for (int j = i + 1; j < n; j++) {
                    pq.add(new Edge(i, j, Math.max(0, calcDistance(x[i], x[j], y[i], y[j]) - r[i] - r[j])));
                }
            }

            double answer;
            while (!pq.isEmpty()) {
                Edge edge = pq.poll();
                if (union(edge.start, edge.end)) {
                    //  벽과 벽이 이어지면
                    if (find(n) == find(n + 1)) {
                        answer = edge.d/ 2;
                        if (answer == 0) {
                            System.out.println(0);
                        } else {
                            System.out.printf("%6f%n", answer);
                        }
                        break;
                    }
                }
            }

        }
    }

    private static boolean union(int start, int end) {
        start = find(start);
        end = find(end);

        if (start != end) {
            parents[end] = start;
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


    private static double calcDistance(int x1, int x2, int y1, int y2) {
        double d;
        d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return d;
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
