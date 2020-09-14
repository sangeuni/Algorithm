package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _14405 {
	/* BOJ - 피카츄 */
	static String s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		
		s = s.replaceAll("pi", "_");
		s = s.replaceAll("ka", "_");
		s = s.replaceAll("chu", "_");
		s = s.replaceAll("_", "");
		System.out.println(s.length() == 0 ? "YES" : "NO");
	}
}
