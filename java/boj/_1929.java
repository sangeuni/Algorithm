package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _1929 {
	/* 소수 찾기(에라토스테네스의 체) */
	public void go() {
		Scanner sc = new Scanner(System.in);
		List<Integer> primes= new ArrayList<>(); // 소수 저장
		int m = sc.nextInt();
		int n = sc.nextInt();
		boolean[] check = new boolean[n+1];	// 소수 체크
		
		for(int i = 2; i<=n;i++) {
			if(check[i]) continue;
			if(!check[i]) primes.add(i);
			
			for(int j = i*2; j<=n; j+=i) {	// 소수의 배수 아이들 체에 거르기
				check[j] = true;
			}
		}
		
		for(int prime : primes) {
			if(prime >= m)
				System.out.println(prime);
		}
		
	}
}
