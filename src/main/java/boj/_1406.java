package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _1406 {
    private void go() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = (br.readLine()).toCharArray();
        List<Character> editor = new LinkedList<>();
        for(char ch: chars){
            editor.add(ch);
        }
        int n = Integer.parseInt(br.readLine());
        ListIterator<Character> iterator = editor.listIterator(editor.size());
        while (n-- >0){
             String command = br.readLine();
             char c = command.charAt(0);
            switch (c){
                case 'L':
                    if(iterator.hasPrevious())
                        iterator.previous();
                   break;
                case 'D':
                    if(iterator.hasNext())
                        iterator.next();
                    break;
                case 'B':
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    char insert = command.charAt(2);
                    iterator.add(insert);
                    break;
            }
        }
        br.close();
        StringBuffer sb = new StringBuffer();
        for(char ch:editor){
            sb.append(ch);
        }
        System.out.println(sb.toString());

    }
}
