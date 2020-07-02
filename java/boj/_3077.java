package boj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class _3077 {
	/* boj - 임진왜란 */
	static Map<String, Integer> map;
	static int[] soo;
	static StringTokenizer st;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		map = new HashMap<>();
		soo = new int[n];
		sc.nextLine();
		st = new StringTokenizer(sc.nextLine());
		int idx = 0;
		while(st.hasMoreTokens()){
			map.put(st.nextToken(), idx++);
		}
		st = new StringTokenizer(sc.nextLine());
		idx = 0;
		while(st.hasMoreTokens()) {
			soo[idx++] = map.get(st.nextToken());
		}
		int answer = 0;
		for(int i = 0; i<n-1; i++) {
			for(int j = i+1; j<n; j++) {
				if(soo[i] < soo[j]) answer++;
			}
		}
		
		System.out.println(answer + "/" + (n*(n-1)/2));
	}
}
