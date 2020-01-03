package boj;

import java.util.Scanner;

public class _1978 {
	/* 소수 찾기
	 * 2 <= i <= n-1
	 * 2 <= i <= n/2
	 * 2 <= i*i <= n (2 <= i <= root n)
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int count = 0;
		for (int i = 0; i < size; i++) {
			int n = sc.nextInt();
			if (isPrime(n))
				count++;
		}
		System.out.println(count);
	}

	public boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i*i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
