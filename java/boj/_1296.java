package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1296 {
	/* boj - 데이트 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String man = in.readLine();
		int n = stoi(in.readLine());
		
		String[] girls = new String[n];
		for (int i = 0; i < n; i++) {
			girls[i] = in.readLine();
		}
		Arrays.sort(girls);
		
		int[] minsik = new int[4];
		for(int i = 0; i<man.length(); i++) {
			if (man.charAt(i) == 'L') {
				minsik[0]++;
			} else if (man.charAt(i) == 'O') {
				minsik[1]++;
			} else if (man.charAt(i) == 'V') {
				minsik[2]++;
			} else if (man.charAt(i) == 'E') {
				minsik[3]++;
			}
		}
		
		String answer="";
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			String name = girls[i];
			int[] love = new int[4];
			for (int j = 0; j < name.length(); j++) {
				if (name.charAt(j) == 'L') {
					love[0]++;
				} else if (name.charAt(j) == 'O') {
					love[1]++;
				} else if (name.charAt(j) == 'V') {
					love[2]++;
				} else if (name.charAt(j) == 'E') {
					love[3]++;
				}
			}
			int l = minsik[0] + love[0];
			int o = minsik[1] + love[1];
			int v = minsik[2] + love[2];
			int e = minsik[3] + love[3];

			int score = ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % 100;
			if (max < score) {
				max = score;
				answer = name;
			}
		}
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
