package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1719 {
    /*boj - 택배*/
    static int n, m;
    static int[] distance, visited;
    static int[] prev;
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        private int idx;
        private int d;

        public Node(int idx, int d) {
            this.idx = idx;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        distance = new int[n + 1];
        visited = new int[n + 1];
        prev = new int[n + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int from, to, time;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            from = stoi(st.nextToken());
            to = stoi(st.nextToken());
            time = stoi(st.nextToken());

            graph.get(from).add(new Node(to, time));
            graph.get(to).add(new Node(from, time));
        }
        System.out.println(getPrev());
    }

    private static String getPrev() {
        StringBuilder sb = new StringBuilder();
        for (int idx = 1; idx <= n; idx++) {
            dijkstra(idx);
            for (int i = 1; i <= n; i++) {
                if (prev[i] == 0) {
                    sb.append("-").append(" ");
                } else if (prev[i] == idx) {
                    sb.append(i).append(" ");
                } else {
                    int next = prev[i];
                    while (prev[next] != idx) {
                        next = prev[next];
                    }
                    sb.append(next).append(" ");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }


    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(prev, 0);
        Arrays.fill(visited, 0);
        Arrays.fill(distance, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll().idx;

            if (visited[cur] == 1) continue;
            visited[cur] = 1;

            for (Node node : graph.get(cur)) {
                if (distance[node.idx] > distance[cur] + node.d) {
                    distance[node.idx] = distance[cur] + node.d;
                    prev[node.idx] = cur;
                    pq.add(new Node(node.idx, distance[node.idx]));
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
