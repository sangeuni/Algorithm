package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6987 {
    /*boj - 월드컵*/
    static int[][] matches = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}};
    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            result = new int[6][3];

            // input
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    result[j][k] = stoi(st.nextToken());
                    sum += result[j][k];
                }
            }

            boolean valid = backtracking(0);
            if (sum == 30 && valid) sb.append(1 + " ");
            else sb.append(0 + " ");
        }
        System.out.println(sb.toString().trim());
    }

    private static boolean backtracking(int count) {
        if (count == 15) return true;

        // 승 : 패
        if (result[matches[count][0]][0] > 0 && result[matches[count][1]][2] > 0) {
            result[matches[count][0]][0]--;
            result[matches[count][1]][2]--;
            if (backtracking(count + 1)) return true;
            result[matches[count][0]][0]++;
            result[matches[count][1]][2]++;
        }

        // 무 : 무
        if (result[matches[count][0]][1] > 0 && result[matches[count][1]][1] > 0) {
            result[matches[count][0]][1]--;
            result[matches[count][1]][1]--;
            if (backtracking(count + 1)) return true;
            result[matches[count][1]][1]++;
            result[matches[count][0]][1]++;
        }

        // 패 : 승
        if (result[matches[count][0]][2] > 0 && result[matches[count][1]][0] > 0) {
            result[matches[count][0]][2]--;
            result[matches[count][1]][0]--;
            if (backtracking(count + 1)) return true;
            result[matches[count][1]][0]++;
            result[matches[count][0]][2]++;
        }

        return false;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
