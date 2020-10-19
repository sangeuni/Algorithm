package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _4485 {
    /*boj - 녹색 옷 입은 애가 젤다지?*/
    static int n;
    static Node[][] map;
    static int[] distance, visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        private int idx;
        private int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "idx=" + idx +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
        while (true) {
            n = stoi(br.readLine());

            if (n == 0) break;

            map = new Node[n][n];
            distance = new int[n * n];
            visited = new int[n * n];

            graph = new ArrayList<>();

            for (int i = 0; i < n * n; i++) {
                graph.add(new ArrayList<>());
            }

            int idx = 0;
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = new Node(idx++, stoi(st.nextToken()));
                }
            }

            // 각 정점에 연결된 간선 추가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 2차원 배열이기 때문에 4방향 탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            graph.get(map[i][j].idx).add(new Node(map[nx][ny].idx, map[nx][ny].value));
                        }
                    }
                }
            }

            dijkstra(0);

            System.out.println("Problem " + tc++ + ": " + (map[0][0].value + distance[n * n - 1]));
        }
    }

    static void dijkstra(int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll().idx;

            if (visited[cur] == 1) continue;
            visited[cur] = 1;

            for (Node node : graph.get(cur)) {
                if (distance[node.idx] > distance[cur] + node.value) {
                    distance[node.idx] = distance[cur] + node.value;

                    pq.add(new Node(node.idx, distance[node.idx]));
                }
            }
        }
    }

    private static int stoi(String input) {
        return Integer.parseInt(input);
    }
}
