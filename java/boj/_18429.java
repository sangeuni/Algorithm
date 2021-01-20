package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18429 {
    /*boj - 근손실*/
    static int n, k, answer;
    static int[] order;
    static Kit[] info;

    static class Kit {
        private int weight;
        private boolean used;

        public Kit(int weight, boolean used) {
            this.weight = weight;
            this.used = used;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = stoi(st.nextToken());
        k = stoi(st.nextToken());

        order = new int[n];
        info = new Kit[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            info[i] = new Kit(stoi(st.nextToken()), false);
        }

        answer = 0;
        for (int i = 0; i < n; i++) {
            int sum = 500 + info[i].weight - k;
            if(sum >= 500){
                info[i].used = true;
                dfs(i, 1, sum);
                info[i].used = false;
            }
        }

        System.out.println(answer);

    }

    private static void dfs(int num, int count, int sum) {
        if (count == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!info[i].used && (sum + info[i].weight - k) >= 500) {
                info[i].used = true;
                dfs(i, count + 1, sum + info[i].weight - k);
                info[i].used = false;
            }
        }
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
