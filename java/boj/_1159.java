package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1159 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        while (n-- > 0) {
            arr[br.readLine().charAt(0) - 'a']++;
        }
        br.close();
        String entry = "";
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                entry += String.valueOf((char) (i + 'a'));
            }
        }

        if (entry.equals(""))
            System.out.println("PREDAJA");
        else
            System.out.println(entry);
    }
}
