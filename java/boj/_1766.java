package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1766 {
    /*boj - 문제집*/
    static int n, m;
    static int[] indegree;
    static List<List<Integer>> graph;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        indegree = new int[n + 1];

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = stoi(st.nextToken());
            b = stoi(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        topologicalSort();

        System.out.println(sb.toString().trim());
    }

    private static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0){
                pq.offer(i);
            }
        }

        sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int p = pq.poll();
            sb.append(p + " ");

            for (int node : graph.get(p)) {
                indegree[node]--;

                if (indegree[node] == 0) {
                    pq.offer(node);
                }
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
