package boj;

import java.util.Arrays;
import java.util.Scanner;

public class _1339 {
	/*
	 *  단어 수학
	 */
	public void go() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 단어의 개수
		sc.nextLine();
		String[] str = new String[n]; // 단어 배열
		int[] alpha = new int[26];

		for (int i = 0; i < n; i++) {
			str[i] = sc.nextLine();
			for (int j = 0; j < str[i].length(); j++) {
				alpha[str[i].charAt(j) - 65] = 1;
			}
		} // 단어에서 사용된 알파벳 표시

		int count = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == 1)
				count++;
		} // 사용된 알파벳 개수

		int[] numbers = new int[count]; // 매칭할 숫자 배열(9, 8, 7, .. , 0)
		int[] a = new int[count]; // 사용된 알파벳의 인덱스 저장

		count = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] == 1) {
				a[count++] = i;
			}
		}

		count = 9;
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = count--;
		}

		Arrays.sort(numbers); // 다음 순열 구하기 위해 정렬

		int answer = 0;
		do {
			for (int i = 0; i < a.length; i++) {
				alpha[a[i]] = numbers[i]; // 알파벳과 숫자 매칭
			}
			answer = Math.max(answer, calc(str, alpha, a, numbers)); // 단어 수학 계산
		} while (next_permutation(a, a.length));
		System.out.println(answer);
	}

	public int calc(String[] str, int[] alpha, int[] a, int[] numbers) {
		int sum = 0;
		for (int i = 0; i < str.length; i++) {
			for (int j = str[i].length() - 1, x = 1; j >= 0; j--, x *= 10) {
				sum += (alpha[str[i].charAt(j) - 65] * x);
			}
		}
		return sum;
	}

	public boolean next_permutation(int[] a, int n) {
		int i = n - 1;
		while (i > 0 && a[i - 1] >= a[i])
			i -= 1;
		if (i <= 0)
			return false;
		int j = n - 1;
		while (a[i - 1] >= a[j])
			j -= 1;
		swap(a, i - 1, j);
		j = n - 1;
		while (i < j) {
			swap(a, i, j);
			i += 1;
			j -= 1;
		}
		return true;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
