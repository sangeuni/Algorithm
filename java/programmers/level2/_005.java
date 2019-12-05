package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class _005 {
	 /*
	  * Leve2 - 다리를 건너는 트럭
	  *
	  * */
	private class Truck{
		private int weight;
		private int location;
		
		public Truck(int weight){
			this.weight = weight;
			this.location = 1;
		}
		
		void moving() {
			this.location++;
		}
		
	}	
	public int solution(int bridge_length, int weight, int[] truck_weights) {
       int answer = 0;
       int curWeight = 0;
       
       Queue<Truck> waitQ = new LinkedList<>();
       Queue<Truck> moveQ = new LinkedList<>();
       
       for(int w : truck_weights) {
    	   waitQ.offer(new Truck(w));
       }
       
       while(!waitQ.isEmpty() || !moveQ.isEmpty()) {
    	   answer++;
    	   
    	   if(moveQ.isEmpty()) {
    		   Truck t = waitQ.poll();
    		   curWeight += t.weight;
    		   moveQ.offer(t);
    		   continue;
    	   }
    	   
    	   for(Truck t : moveQ) {
    		   t.moving();
    	   }
    	   
    	   if(moveQ.peek().location > bridge_length) {
    		   curWeight -= moveQ.peek().weight;
    		   moveQ.poll();
    	   }
    	   
    	   if(!waitQ.isEmpty() && waitQ.peek().weight + curWeight <= weight) {
    		   Truck t = waitQ.poll();
    		   curWeight += t.weight;
    		   moveQ.offer(t);
    	   }
    	   
       }
       return answer;
    }
	
}
