package boj;

import java.util.Scanner;

public class _2609 {
	/* 
	 * 최대공약수와 최소공배수
	 * GCD(a, b) == GCD(b, a%b)
	 * LCD(a, b) == a*b / GCD(b, a%b)
	 */
	public void go() {
	Scanner sc = new Scanner(System.in);
	int a = sc.nextInt();
	int b = sc.nextInt();
	int g = gcd(a,b);
    int l = a*b/gcd(a,b);
	System.out.println(g);
	System.out.println(l);
	}
	
	public int gcd(int a,int b) {
		if(b == 0)
			return a;
		return gcd(b, a%b);
	}
}
