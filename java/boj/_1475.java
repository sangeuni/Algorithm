package boj;

import java.util.Scanner;

public class _1475 {
	/* boj - 방 번호 */
	static int[] nums;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		nums = new int[10];

		for (int i = 0; i < n.length(); i++) {
			nums[n.charAt(i) - '0']++;
		}
		nums[6] = (nums[6] + nums[9] + 1) / 2;
		nums[9]= 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, nums[i]);
		}
		System.out.println(max);
	}
}
