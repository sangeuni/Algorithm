package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2798 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int n = Integer.parseInt(st.nextToken());
        int blackjack = Integer.parseInt(st.nextToken());
        int[] numbers = stringToArray(n, br.readLine());

        int win = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int temp = numbers[i] + numbers[j] + numbers[k];
                    if (win < temp && temp <= blackjack)
                        win = temp;
                }
            }
        }
        System.out.println(win);
    }

    private int[] stringToArray(int size, String str) {
        int[] numbers = new int[size];
        int index = 0;
        StringTokenizer st = new StringTokenizer(str, " ");
        while (st.hasMoreTokens()) {
            numbers[index++] = Integer.parseInt(st.nextToken());
        }
        return numbers;
    }
}
