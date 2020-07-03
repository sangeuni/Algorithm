package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class _9536 {
	/* boj - 여우는 어떻게 울지? */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(in.readLine());
		while (tc-- > 0) {
			String[] record = in.readLine().split(" ");
			Set<String> set = new HashSet<>();
			while (true) {
				String s = in.readLine();
				if (s.equals("what does the fox say?"))
					break;
				
				String[] sample = s.split(" ");
				set.add(sample[sample.length-1]);
			}
			
			StringBuilder sb = new StringBuilder();
			for(String sound : record) {
				if(!set.contains(sound))
					sb.append(sound +" ");
			}
			System.out.println(sb.toString().trim());
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
