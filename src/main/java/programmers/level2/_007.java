package programmers.level2;

public class _007 {
	/*
	 * Level2 - 타겟 넘버
	 *
	 */
	public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, target, 0, 0);
		return answer;
	}

	private int dfs(int[] numbers, int target, int depth, int sum) {
		if (numbers.length == depth) {
			if (target == sum)
				return 1;
			return 0;
		}

		return dfs(numbers, target, depth + 1, sum + numbers[depth])
				+ dfs(numbers, target, depth + 1, sum - numbers[depth]);
	}
}
