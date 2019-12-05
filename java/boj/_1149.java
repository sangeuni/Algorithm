package boj;

import java.util.Scanner;

public class _1149 {
	int n;
	int r, g, b;
	int temp_r, temp_g, temp_b;

	private void go() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		g = sc.nextInt();
		b = sc.nextInt();

		for (int i = 1; i < n; i++) {
			temp_r = sc.nextInt();
			temp_g = sc.nextInt();
			temp_b = sc.nextInt();

			temp_r += Math.min(g, b);
			temp_g += Math.min(r, b);
			temp_b += Math.min(r, g);

			r = temp_r;
			g = temp_g;
			b = temp_b;
		}

		System.out.println(Math.min(Math.min(r, g), b));
		sc.close();
	}
}
