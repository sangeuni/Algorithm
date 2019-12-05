package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _6603 {
	/* 로또 */
	List<Integer> numbers;
	List<Lotto> lottoList;
	int[] comArr;

	class Lotto {
		int[] elem;

		public Lotto() {
			elem = new int[6];
		}
	}

	public void combination(int[] comArr, int n, int r, int index, int target) {
		// 공을 다 뽑은 경우
		if (r == 0) {
			Lotto lotto = new Lotto();
			for (int i = 0; i < 6; i++) {
				lotto.elem[i] = comArr[i];
			}
			lottoList.add(lotto);
			return;
		} // 공을 다 검사했지만, 6개를 못 뽑은 경우
		else if (target == n) {
			return;
		} else {
			comArr[index] = numbers.get(target);
			combination(comArr, n, r - 1, index + 1, target + 1);
			combination(comArr, n, r, index, target + 1);
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			comArr = new int[6];
			lottoList = new LinkedList<>();
			numbers = new ArrayList<>();
			int size = sc.nextInt();

			if (size == 0)
				break;

			for (int i = 0; i < size; i++) {
				numbers.add(sc.nextInt());
			}

			combination(comArr, numbers.size(), 6, 0, 0);
			printLotto();
		}
	}

	public void printLotto() {
		for (Lotto l : lottoList) {
			for (int i = 0; i < 6; i++) {
				System.out.print(l.elem[i] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
