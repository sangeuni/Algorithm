package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class _10828 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        while (n > 0) {
            String instruction = br.readLine();
            switch (instruction) {
                case "pop":
                    if (stack.size() != 0) {
                        System.out.println(stack.get(stack.size() - 1));
                        stack.remove(stack.size() - 1);
                    } else
                        System.out.println(-1);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if (stack.size() == 0) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if (stack.size() != 0) {
                        System.out.println(stack.get(stack.size() - 1));
                    } else
                        System.out.println(-1);
                    break;
                default:
                    StringTokenizer st = new StringTokenizer(instruction, " ");
                    if (st.nextToken().equals("push")) {
                        int num = Integer.parseInt(st.nextToken());
                        stack.add(num);
                    }
                    break;
            }
            n--;
        }
        br.close();
    }
}
