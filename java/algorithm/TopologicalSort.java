package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    /*
    algorithm - 위상 정렬
    */
    static int n, m;
    static int[] indegree;
    static List<List<Integer>> graph;
    static List<Integer> result;

    public static void main(String[] args) {
        n = 7; // 노드 수
        m = 7; // 간선 수

        graph = new ArrayList<>();
        result = new ArrayList<>();
        indegree = new int[n + 1];

        // 간선
        int[] n1 = {1, 2, 5, 1, 3, 4, 3};
        int[] n2 = {2, 5, 6, 3, 4, 6, 7};


        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 만들기 & indegree 정보 넣기
        for (int i = 0; i < m; i++) {
            graph.get(n1[i]).add(n2[i]);
            indegree[n2[i]]++;
        }

        topologicalSort();

        // 위상 정렬 결과 출력
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for(int i : graph.get(node)){
                indegree[i]--;

                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
        }
    }
}
