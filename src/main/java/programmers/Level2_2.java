package programmers;

public class Level2_2 {
    /*
     * Level2 - 예상 대진표
     *
     * Description : N명이 참가하는 대회에서
     *               토너먼트는 1번↔2번, 3번↔4번, ... , N-1번↔N번 참가자 끼리 게임
     *               A번 참가자와 B번 참가자는 몇 번째 라운드에서 만날게될까?
     *               (A번 참가자와 B번 참가자는 서로 붙게 되기 전까지 항상 이긴다고 가정)
     * Input : 게임 참가자 수 N, 참가자 번호 A, 경쟁자 번호 B
     * Output : A와 B가 몇번째 라운드에서 만나는지 return
     *
     * */

    public int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;

            answer++;
        }
        return answer;
    }


}
