package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _10867 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        List<Integer> sorted = new ArrayList<>();
        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers, " ");
        br.close();
        while (st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (int i : set) {
            sorted.add(i);
        }
        Collections.sort(sorted);
        for (int i : sorted) {
            System.out.print(i + " ");
        }
    }
}
