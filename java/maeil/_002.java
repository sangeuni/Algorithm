package maeil;

public class _002 {

	public int solution(int n) {
		int x = 0;
		int y = 1;
		int z, sum = 0;

		while (x <= n) {
			if (x % 2 == 0) {
				sum += x;
			}
			z = x + y;
			x = y;
			y = z;
		}
		return sum;
	}
}
