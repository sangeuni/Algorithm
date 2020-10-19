package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1647 {
    /*boj - 도시 분할 계획*/
    static int n, m;
    static int[] parents;

    static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        parents = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            parents[i] = i;
        }

        int a, b, c;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = stoi(st.nextToken());
            b = stoi(st.nextToken());
            c = stoi(st.nextToken());
            pq.add(new Edge(a, b, c));
        }

        int count = 0;
        int answer = 0;
        for (int i = 0; i < m; i++) {
            if(count == n-2)break;
            Edge edge = pq.poll();
            if (!isCycle(edge.start, edge.end)) {
                answer += edge.value;
                count++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isCycle(int start, int end) {
        start = find(start);
        end = find(end);

        if (start != end) {
            parents[end] = start;
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
