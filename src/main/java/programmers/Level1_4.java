package programmers;

public class Level1_4 {
    /*
    * Level1 - 가운데 글자 가져오기
    *
    * */
    public String solution(String s) {
        String answer = "";
        int n = s.length();
        if(n%2 ==0){
            answer = s.substring((n/2)-1,(n/2)+1);
        }else{
            answer = s.substring(n/2,(n/2)+1);
        }

        return answer;
    }
}
