package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2953 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = -1;
        int winner = -1;
        for (int i = 0; i < 5; i++) {
            int[] arr = stringToArray(br.readLine());
            int sum = addScore(arr);
            if (sum > max) {
                max = sum;
                winner = i + 1;
            }
        }
        br.close();
        System.out.println(winner + " " + max);
    }

    private int addScore(int[] arr) {
        int score = 0;
        for (int i = 0; i < arr.length; i++) {
            score += arr[i];
        }
        return score;
    }

    private int[] stringToArray(String str) {
        int[] score = new int[4];
        int index = 0;
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()) {
            score[index++] = Integer.parseInt(st.nextToken());
        }
        return score;
    }
}
