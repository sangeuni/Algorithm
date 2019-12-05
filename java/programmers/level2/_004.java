package programmers.level2;

public class _004 {
	 /*
	  * Leve2 - 탑
	  *
	  * */
	 public int[] solution(int[] heights) {
	        int[] answer = new int[heights.length];		// 0으로 초기화
	       
	       for(int i = heights.length-1; i>0; i--) {
	    	   for(int j = i-1; j>=0; j--)
	    	   if(heights[i] <heights[j]) {
	    		   answer[i] = j+1;
	    		   break;
	    	   }
	       }
	       return answer;
	    }
}
