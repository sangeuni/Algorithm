package algorithm;

public class Fibonacci {
	int x = 1;
	int y = 1;
	int z = 0;

	private int fibonacci(int n) {
		if (n <= 1)
			return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	private int dynamicFibonacci(int n) {
		if (n <= 1)
			return 1;
		for (int i = 1; i < n; i++) {
			z = x + y;
			x = y;
			y = z;
		}
		return z;
	}
}
