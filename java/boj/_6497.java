package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _6497 {
    static int n, m, total, sum;
    static int[] parents;

    static class Edge implements Comparable<Edge> {
        private int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<Edge> pq;
        while (true) {
            st = new StringTokenizer(br.readLine());
            n = stoi(st.nextToken());
            m = stoi(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }


            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            pq = new PriorityQueue<Edge>();
            total = 0;
            int from, to, cost;
            // input edge
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                from = stoi(st.nextToken());
                to = stoi(st.nextToken());
                cost = stoi(st.nextToken());
                pq.add(new Edge(from, to, cost));
                total += cost;
            }

            sum = 0;
            int count = 0;
            // m만틈 반복해서 edge 뽑기
            for (int i = 0; i < m; i++) {
                if (count == n - 1) {
                    break;
                }
                Edge edge = pq.poll();
                if (!isCycle(edge.from, edge.to)) {
                    sum += edge.cost;
                }
            }

            System.out.println(total - sum);
        }
    }

    private static boolean isCycle(int from, int to) {
        from = find(from);
        to = find(to);

        if (from != to) {
            parents[to] = from;
            return false;
        }
        return true;
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
