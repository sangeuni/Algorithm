package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _3052 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            int elem = Integer.parseInt(br.readLine());
            arr[i] = elem % 42;
            set.add(arr[i]);
        }
        br.close();
        System.out.println(set.size());
    }
}
