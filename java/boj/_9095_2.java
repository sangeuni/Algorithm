package boj;

import java.util.Scanner;

public class _9095_2 {
	/* 1, 2, 3 더하기(ver.Brute Force) */
	public void n_for() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		while (tc-- > 0) {
			int n = sc.nextInt();
			int ans = 0;
			for (int f1 = 1; f1 <= 3; f1++) {
				if (f1 == n) {
					ans += 1;
				} // fi
				for (int f2 = 1; f2 <= 3; f2++) {
					if (f1 + f2 == n) {
						ans += 1;
					} // fi
					for (int f3 = 1; f3 <= 3; f3++) {
						if (f1 + f2 + f3 == n) {
							ans += 1;
						} // fi
						for (int f4 = 1; f4 <= 3; f4++) {
							if (f1 + f2 + f3 + f4 == n) {
								ans += 1;
							} // fi
							for (int f5 = 1; f5 <= 3; f5++) {
								if (f1 + f2 + f3 + f4 + f5 == n) {
									ans += 1;
								} // fi
								for (int f6 = 1; f6 <= 3; f6++) {
									if (f1 + f2 + f3 + f4 + f5 + f6 == n) {
										ans += 1;
									} // fi
									for (int f7 = 1; f7 <= 3; f7++) {
										if (f1 + f2 + f3 + f4 + f5 + f6 + f7 == n) {
											ans += 1;
										} // fi
										for (int f8 = 1; f8 <= 3; f8++) {
											if (f1 + f2 + f3 + f4 + f5 + f6 + f7 + f8 == n) {
												ans += 1;
											} // fi
											for (int f9 = 1; f9 <= 3; f9++) {
												if (f1 + f2 + f3 + f4 + f5 + f6 + f7 + f8 + f9 == n) {
													ans += 1;
												} // fi
												for (int f10 = 1; f10 <= 3; f10++) {
													if (f1 + f2 + f3 + f4 + f5 + f6 + f7 + f8 + f9 + f10 == n) {
														ans += 1;
													} // fi
												} // f10
											} // f9
										} // f8
									} // f7
								} // f6
							} // f5
						} // f4
					} // f3
				} // f2
			} // f1
			System.out.println(ans);
		} // while
	}
	
	public int recursion(int sum, int goal) {
		if(sum > goal) return 0;
		if(sum == goal) return 1;
		int now  = 0;
		for(int i = 1; i<=3; i++) {
			now = recursion(sum+i, goal);
		}
		return now;
	}
}
