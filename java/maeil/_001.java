package maeil;

public class _001 {
	int solution(int[] array) {
		int current = array[0];
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			current = Math.max(current + array[i], array[i]);
			max = Math.max(max, current);
		}
		return max;
	}
}
