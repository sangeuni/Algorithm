package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _13424 {
   /* boj - 비밀 모임*/
    static int n, m, k;
    static int[] d, visited;
    static List<List<Node>> list;

    static class Node implements Comparable<Node> {
        private int room;
        private int v;

        public Node(int room, int v) {
            this.room = room;
            this.v = v;
        }


        @Override
        public int compareTo(Node o) {
            return this.v - o.v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = stoi(br.readLine());

        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = stoi(st.nextToken());
            m = stoi(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                list.add(new ArrayList<>());
            }

            int start, end, val;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                start = stoi(st.nextToken());
                end = stoi(st.nextToken());
                val = stoi(st.nextToken());

                list.get(start).add(new Node(end, val));
                list.get(end).add(new Node(start, val));
            }

            k = stoi(br.readLine());
            List<Integer> friends = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                friends.add(stoi(st.nextToken()));
            }

            int answer = Integer.MAX_VALUE;
            int room = 0;
            for (int i = 1; i <= n; i++) {
                init();
                dijkstra(i);
                int sum = 0;
                for (int j : friends) {
                    sum += d[j];
                }
                if (answer > sum) {
                    answer = sum;
                    room = i;
                }
            }
            System.out.println(room);
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(start, 0));

        Arrays.fill(d, Integer.MAX_VALUE);
        d[start] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.poll().room;

            if (visited[cur] == 1) continue;
            visited[cur] = 1;

            for (Node node : list.get(cur)) {
                if (d[node.room] > d[cur] + node.v) {
                    d[node.room] = d[cur] + node.v;
                    pq.add(new Node(node.room, d[node.room]));
                }
            }
        }
    }


    private static void init() {
        d = new int[n + 1];
        visited = new int[n + 1];
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
