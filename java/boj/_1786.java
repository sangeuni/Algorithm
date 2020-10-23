package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1786 {
   /* boj - 찾기*/
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] t = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();

        sb = new StringBuilder();
        System.out.println(kmp(t, p));
        System.out.println(sb.toString());
    }

    private static int kmp(char[] t, char[] p) {
        int[] pi = getPi(p);
        int n = t.length;
        int m = p.length;
        int j = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && t[i] != p[j]) {
                j = pi[j - 1];
            }
            if (t[i] == p[j]) {
                if (j == m - 1) {
                    count++;
                    sb.append((i - m + 2) + " ");
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    private static int[] getPi(char[] p) {
        int[] pi = new int[p.length];
        int m = p.length;
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }

            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
