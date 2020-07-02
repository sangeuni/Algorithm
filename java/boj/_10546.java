package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class _10546 {
	/* boj - 배부른 마라토너 */
	static Map<String, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = stoi(br.readLine());
		map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			if (!map.containsKey(name)) {
				map.put(name, 1);
			} else {
				map.replace(name, map.get(name) + 1);
			}
		}

		for (int i = 0; i < n - 1; i++) {
			String name = br.readLine();
			if (map.get(name) == 1) {
				map.remove(name);
			} else {
				map.replace(name, map.get(name) - 1);
			}
		}
		for(String s : map.keySet()) {
			bw.write(s);
		}
		bw.close();
	}

	static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
