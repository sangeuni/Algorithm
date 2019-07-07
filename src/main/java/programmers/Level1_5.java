package programmers;

import java.util.ArrayList;
import java.util.List;

public class Level1_5 {
    public int[] solution(int[] arr) {
        int[] answer;
        List<Integer> answerList = new ArrayList<>();
        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            if (temp != arr[i])
                answerList.add(arr[i]);
            temp = arr[i];
        }
        answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
