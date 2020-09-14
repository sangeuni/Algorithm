public class Main {
	static int resultCount = Integer.MAX_VALUE;
	static int resultNumber = -1;

	public static void main(String[] args) {
		solution(73425);
		solution(9);
	}

	static void go(String n, int cnt) {
		if (n.length() == 1) {
			if (resultCount >= cnt) {
				resultCount = cnt;
				resultNumber = Integer.valueOf(n);
			}
			return;
		}

		int len = n.length();
		for (int i = 1; i <= len - 1; i++) {
			int j = len - i;
			int first = splitNumber(n, 1, i);
			int second = splitNumber(n, i + 1, len);

			if (first != -1 && second != -1) {
				go(Integer.toString(first + second), cnt + 1);
			}
		}
	}

	static int splitNumber(String n, int s, int e) {
		String sub = n.substring(s - 1, e);
		if (sub.charAt(0) == '0') {
			return -1;
		} else {
			return Integer.valueOf(sub);
		}
	}

	static int[] solution(int n) {
		int[] answer = new int[2];

		go(String.valueOf(n), 0);
		answer[0] = resultCount;
		answer[1] = resultNumber;
		for (int i : answer) {
			System.out.println(i);
		}
		return answer;
	}
}
