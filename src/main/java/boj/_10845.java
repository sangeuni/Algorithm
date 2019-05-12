package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10845 {
    private void go() throws IOException {
        LinkedList<Integer> queue = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int i = 0;
        while (count > i) {
            String instruction = br.readLine();
            switch (instruction) {
                case "size":
                    System.out.println(queue.size());
                    break;
                case "pop":
                    if (queue.size() == 0)
                        System.out.println(-1);
                    else {
                        System.out.println(queue.peek());
                        queue.poll();
                    }
                    break;
                case "front":
                    if (queue.size() == 0)
                        System.out.println(-1);
                    else System.out.println(queue.peek());
                    break;
                case "back":
                    if (queue.size() == 0)
                        System.out.println(-1);
                    else System.out.println(queue.get(queue.size() - 1));
                    break;
                case "empty":
                    if (queue.size() == 0)
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                default:
                    StringTokenizer stringTokenizer = new StringTokenizer(instruction, " ");
                    if (stringTokenizer.nextToken().equals("push")) {
                        int elem = Integer.parseInt(stringTokenizer.nextToken());
                        queue.offer(elem);
                    }
                    break;
            }
            i++;
        }
        br.close();
    }
}
