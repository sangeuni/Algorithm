package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3613 {
	/* boj - java vs c++ */
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String answer = "";
		boolean err = false;
		StringBuilder sb = new StringBuilder();
		if (str.charAt(0) == '_' || Character.isUpperCase(str.charAt(0)) || str.contains("__")
				|| str.charAt(str.length() - 1) == '_') {
			err = true;
		} else if (str.contains("_")) {
			String[] var = str.split("_");
			loop: for (int i = 0; i < var.length; i++) {
				for (int j = 0; j < var[i].length(); j++) {
					if (Character.isUpperCase(var[i].charAt(j))) {
						err = true;
						break loop;
					} else if (i != 0 && j == 0) {
						sb.append(Character.toUpperCase(var[i].charAt(j)));
					} else {
						sb.append(var[i].charAt(j));
					}
				}
			}
		} // c++ -> java
		else {
			for (int i = 0; i < str.length(); i++) {
				if (Character.isUpperCase(str.charAt(i))) {
					sb.append('_');
					sb.append(Character.toLowerCase(str.charAt(i)));
				} else {
					sb.append(str.charAt(i));
				}
			}
		} // java -> c++
		answer = (err ? "Error!" : sb.toString());
		System.out.println(answer);
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
