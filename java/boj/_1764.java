package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class _1764 {
	/* boj - 듣보잡 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		
		Set<String> set = new HashSet<>();
		for(int i = 0; i<n; i++) {
			set.add(in.readLine());
		}
		
		List<String> list = new LinkedList<>();
		for(int i = 0; i<m; i++) {
			String name = in.readLine();
			if(set.contains(name)) {
				list.add(name);
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for(String s :  list) {
			System.out.println(s);
		}
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
