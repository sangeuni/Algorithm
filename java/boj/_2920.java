package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2920 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = stringToArray(br.readLine());
        br.close();
        String ordered;
        if (arr[0] < arr[1]) {
            ordered = "ascending";
            for (int i = 1; i < 7; i++) {
                if (arr[i] > arr[i + 1])
                    ordered = "mixed";
            }
        } else {
            ordered = "descending";
            for (int i = 1; i < 7; i++) {
                if (arr[i] < arr[i + 1])
                    ordered = "mixed";
            }
        }
        System.out.println(ordered);
    }

    private int[] stringToArray(String numbers) {
        int[] arr = new int[8];
        int index = 0;
        StringTokenizer st = new StringTokenizer(numbers, " ");
        while (st.hasMoreTokens()) {
            arr[index++] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
