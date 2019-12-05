package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class _10866 {
    private void go() throws IOException {
        LinkedList<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int count = Integer.parseInt(br.readLine());
        while (count > 0){
            String instruction = br.readLine();

            switch (instruction){
                case "pop_front":
                    if(deque.isEmpty()) sb.append(-1+"\n");
                    else sb.append(deque.pollFirst()+"\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) sb.append(-1+"\n");
                    else sb.append(deque.pollLast()+"\n");
                    break;
                case "size":
                    sb.append(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case "front":
                    if(deque.size() == 0) sb.append(-1+"\n");
                    else sb.append(deque.peekFirst()+"\n");
                    break;
                case "back":
                    if(deque.size() == 0) sb.append(-1+"\n");
                    else sb.append(deque.peekLast()+"\n");
                    break;
                default:
                    StringTokenizer st = new StringTokenizer(instruction," ");
                    String push = st.nextToken();
                    if(push.equals("push_front")){
                        int elem = Integer.parseInt(st.nextToken());
                        deque.add(0,elem);
                    }
                    if(push.equals("push_back")){
                        int elem = Integer.parseInt(st.nextToken());
                        deque.add(elem);
                    }
                    break;
            }
            count --;
        }
        br.close();
        System.out.println(sb);
    }
}
