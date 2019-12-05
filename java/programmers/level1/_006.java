package programmers.level1;

import java.util.HashSet;

public class _006 {
	/*
	 * Level1 - 체육복
	 *
	 */
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		HashSet reserveList = new HashSet();
		HashSet lostList = new HashSet();

		// 중복 제거
		for (int i : reserve)
			reserveList.add(i);
		for (int i : lost) {
			if (reserveList.contains(i))
				reserveList.remove(i);
			else
				lostList.add(i);
		}

		for (int i : lost) {
			if (lostList.contains(i)) {
				if (reserveList.contains(i - 1))
					reserveList.remove(i - 1);
				else if (reserveList.contains(i + 1))
					reserveList.remove(i + 1);
				else
					answer--;
			}
		}

		return answer;
	}
}
