package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2887 {
   /* boj - 행성 터널*/
    static int n;
    static int[] p;
    static List<Node> list;

    static class Edge implements Comparable<Edge> {
        private int start;
        private int end;
        private int val;

        public Edge(int start, int end, int val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return this.val - o.val;
        }
    }

    static class Node {
        private int x;
        private int y;
        private int z;
        private int num;

        public Node(int x, int y, int z, int num) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());

        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        list = new ArrayList<>();
        int x, y, z;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            x = stoi(st.nextToken());
            y = stoi(st.nextToken());
            z = stoi(st.nextToken());

            list.add(new Node(x, y, z, i));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            pq.add(new Edge(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).x - list.get(i + 1).x)));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.y - o2.y;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            pq.add(new Edge(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).y - list.get(i + 1).y)));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.z - o2.z;
            }
        });
        for (int i = 0; i < list.size() - 1; i++) {
            pq.add(new Edge(list.get(i).num, list.get(i + 1).num, Math.abs(list.get(i).z - list.get(i + 1).z)));
        }

        int answer = 0;
        int count = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                answer += edge.val;
                count++;
            }
            if (count == n - 1) {
                break;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            p[b] = a;
        }
    }

    private static int find(int a) {
        if (p[a] == a) {
            return a;
        }
        return p[a] = find(p[a]);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
