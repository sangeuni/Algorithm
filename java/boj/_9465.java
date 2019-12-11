package boj;

import java.util.Scanner;

public class _9465 {
	/* 스티커 */
	public void go() {
		Scanner sc =  new Scanner(System.in);
		int tc = sc.nextInt();
		int[][] d;
		int[][] sticker;
 		while(tc-- >0) {
 			int n = sc.nextInt();
 			sticker = new int[2][n+1];
 			d = new int[2][n+1];
 			for(int i = 0; i<=1; i++) {
 				for(int j = 1; j<=n; j++) {
 					int num = sc.nextInt();
 					sticker[i][j] = num;
 				}
 			}
 			
 			d[0][0] = d[1][0] = 0;
 			d[0][1] = sticker[0][1];
 			d[1][1] = sticker[1][1];
 			
 			for(int i = 2; i<=n; i++) {
 				d[0][i] = Math.max(d[1][i-2], d[1][i-1]) + sticker[0][i];
 				d[1][i] = Math.max(d[0][i-2], d[0][i-1]) + sticker[1][i];
 			}
 			System.out.println(Math.max(d[0][n], d[1][n]));
 		}
	}
}
