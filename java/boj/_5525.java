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
        n = stoi(br.readLine());
        len = stoi(br.readLine());
        s = br.readLine();

        int ioi = 0;
        int answer = 0;
        for (int i = 1; i < len - 1; i++) {
            if (s.charAt(i - 1) == 'I' && s.charAt(i) == 'O' && s.charAt(i + 1) == 'I') {
                ioi++;
                if (ioi == n) {
                    ioi--;
                    answer++;
                }
                i++;
            } else {
                ioi = 0;
            }
        }
        System.out.println(answer);
    }

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
