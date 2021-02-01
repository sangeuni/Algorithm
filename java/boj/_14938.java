package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _14938 {
    /*boj - 서강그라운드*/
    static int n, m, r, answer;
    static int[] distance, items;
    static boolean[] visited;
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
        r = stoi(st.nextToken());

        distance = new int[n + 1];
        items = new int[n + 1];
        visited = new boolean[n + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = stoi(st.nextToken());
        }

        int start, end, d;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            start = stoi(st.nextToken());
            end = stoi(st.nextToken());
            d = stoi(st.nextToken());

            graph.get(start).add(new Node(end, d));
            graph.get(end).add(new Node(start, d));
        }

        answer = 0;
        int sum;
        for (int i = 1; i <= n; i++) {
            init();
            dijkstra(i);
            sum = 0;
            for (int j = 1; j <= n; j++) {
                if (distance[j] <= m) {
                    sum += items[j];
                }
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    private static void init() {
        Arrays.fill(visited, false);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            int cur = pq.poll().idx;
            if (visited[cur]) continue;
            visited[cur] = true;

            for (Node node : graph.get(cur)) {
                if (distance[node.idx] > distance[cur] + node.d) {
                    distance[node.idx] = distance[cur] + node.d;

                    pq.offer(new Node(node.idx, distance[cur] + node.d));
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
