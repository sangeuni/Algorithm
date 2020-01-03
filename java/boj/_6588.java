package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _6588 {
	/* 
	 * 골드바흐의 추측 - 2보다 큰 모든 짝수는 두 소수의 합으로 표현 가능하다. 
	 *  1. 에라토스테네스의 체를 이용하여 소수를 미리 구한다.
	 *  2. check 배열로 n-p가 소수이면 답을 출력한다.  
	 */
	
	public static final int MAX = 1000000;

	public void go() {
		Scanner sc = new Scanner(System.in);
		List<Integer> primes = new ArrayList<>();
		boolean[] check = new boolean[1000001];

		check[0] = check[1] = true;
		for (int i = 2; i * i <= MAX; i++) {
			if (check[i])
				continue;
			primes.add(i);
			for (int j = i * 2; j <= MAX; j += i)
				check[j] = true;
		}

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			for (int p : primes) {
				if (!check[n - p]) {
					System.out.println(n + " = " + p + " + " + (n - p));
					break;
				}
			}
		}

	}
}
