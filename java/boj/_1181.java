package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1181 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> words = new HashSet<>();
        while (n-- > 0) {
            String word = br.readLine();
            words.add(word);
        }
        List<String> list = new ArrayList<>();
        for (String s : words) {
            list.add(s);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() > o2.length() ? 1 : o1.length() == o2.length() ? o1.compareTo(o2) : -1;
            }
        });

        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s + "\n");
        }
        System.out.println(sb.toString());
    }
}
