package programmers;

import java.util.Arrays;

public class Level1_1 {
    /*
    * Level1 - 완주하지 못한 선수
    *
    * */
    public String solution(String[] p, String[] c) {
        String answer = "";
        Arrays.sort(p);
        Arrays.sort(c);
        for(int i = 0; i<c.length; i++){
            if(!p[i].equals(c[i])) {
                answer = p[i];
                break;
            }
        }
        if(answer.isEmpty())
            answer = p[p.length-1];
        return answer;
    }
}
