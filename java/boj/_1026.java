package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _1026 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> a = getArrays(br.readLine());
        List<Integer> b = getArrays(br.readLine());
        br.close();

        Collections.sort(a);
        //Collections.reverse(a);
        Collections.sort(b);
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += (a.get(n - i - 1) * b.get(i));
        }
        System.out.println(answer);
    }

    private List<Integer> getArrays(String readLine) {
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(readLine, " ");
        int index = 0;
        while (st.hasMoreTokens()) {
            list.add(index++, Integer.parseInt(st.nextToken()));
        }
        return list;
    }
}
