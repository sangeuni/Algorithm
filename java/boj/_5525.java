package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5525 {
    /*boj - IOIOI*/
    static int n, len;
    static String s, base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int m = stoi(br.readLine());
        char[] s = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder("I");
        for (int i = 0; i < n; i++) {
            sb.append("OI");
        }

        char[] p = sb.toString().toCharArray();

        System.out.println(kmp(s, p));
    }

    private static int kmp(char[] s, char[] p) {
        int count = 0;
        int n = s.length;
        int m = p.length;
        int j = 0;
        int[] pi = getPi(p);

        for (int i = 0; i < n; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = pi[j - 1];
            }
            if (s[i] == p[j]) {
                if (j == m - 1) {
                    count++;
                    j = pi[j];
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    private static int[] getPi(char[] p) {
        int m = p.length;
        int[] pi = new int[m];
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
