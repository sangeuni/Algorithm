package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _19035 {
	/* boj - 단어공부 */
	static int[] alpha;
	static List<Integer> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		alpha = new int[26];
		s = s.toUpperCase();
		
		for(int i = 0; i<s.length(); i++) {
			alpha[s.charAt(i) - 'A']++;
		}

		list = new LinkedList<>();
		int max = -1;
		char answer = ' ';
		for(int i  = 0; i< alpha.length; i++) {
			if(alpha[i] == 0) continue;
			if(max == alpha[i]) {
				answer = '?';
			}else if(max < alpha[i]) {
				answer = (char)('A' + i);
				max  = alpha[i];
			}
		}
		System.out.println(answer);
	}
}
