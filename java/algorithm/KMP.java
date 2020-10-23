package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMP {
    /*
    * KMP : 문자열 검색 알고리즘
    * 문자열 s에서 p가 나오는 횟수, index 출력
    * */
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        char[] p = br.readLine().toCharArray();

        sb = new StringBuilder();
        System.out.println(kmp(s, p));
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
                    sb.append(i - m + 2).append(" ");
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
}
