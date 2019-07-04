package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2846 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];
        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(str[i]);
        }

        int max = 0;
        int height = 0;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (flag && heights[i] < heights[i + 1]) {
                height += (heights[i + 1] - heights[i]);
                if (max < height) {
                    max = height;
                }
            } else if (!flag && heights[i] < heights[i + 1]) {
                flag = true;
                height = heights[i + 1] - heights[i];
                if (max < height) {
                    max = height;
                }
            } else {
                flag = false;
                height = 0;
            }
        }

        System.out.println(max);
        br.close();
    }

    private void go2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        StringTokenizer s = new StringTokenizer(br.readLine().trim());
        int front = Integer.parseInt(s.nextToken());
        int back = 0;
        int max = 0;
        int height = 0;
        for (int i = 1; i < n; i++) {
            back = Integer.parseInt(s.nextToken());
            if (back > front) {
                height += (back - front);
                if (height > max) {
                    max = height;
                }
            } else {
                height = 0;
            }
            front = back;
        }
        System.out.print(max);
    }
}
