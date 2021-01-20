package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16987 {
    /*boj - 계란으로 계란치기*/
    static int n, answer;
    static Egg[] eggs;

    static class Egg {
        private int durability;
        private int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());

        eggs = new Egg[n];
        StringTokenizer st;
        int durability, weight;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            durability = stoi(st.nextToken());
            weight = stoi(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        answer = 0;
        backtracking(0, 0);

        System.out.println(answer);
    }

    private static void backtracking(int num, int count) {
        answer = Math.max(answer, count);
        if (num == n) return;

        if (eggs[num].durability <= 0) {
            backtracking(num + 1, count);
            return;
        }

        for (int target = 0; target < n; target++) {
            if (num != target && eggs[target].durability > 0) {
                int result = hitting(num, target);
                backtracking(num + 1, count + result);
                revert(num, target);
            }
        }
    }

    private static void revert(int a, int b) {
        eggs[a].durability += eggs[b].weight;
        eggs[b].durability += eggs[a].weight;
    }

    private static int hitting(int a, int b) {
        int result = 0;

        eggs[a].durability -= eggs[b].weight;
        eggs[b].durability -= eggs[a].weight;

        if (eggs[a].durability <= 0) {
            result++;
        }
        if (eggs[b].durability <= 0) {
            result++;
        }
        return result;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
