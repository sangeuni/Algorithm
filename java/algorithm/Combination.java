package algorithm;

import java.util.Arrays;

public class Combination {
	public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		if (r == 0) { // r개의 공을 모두 뽑은 경우
			System.out.println(Arrays.toString(combArr));
			for (int i = 0; i < index; i++)
				System.out.print(arr[combArr[i]] + " ");
			System.out.println();
		} else if (target == n) // 종료 조건, r개의 공을 뽑지 못했지만 전체 공을 모두 검사한 경우
			return;
		else {
			combArr[index] = target;
			doCombination(combArr, n, r - 1, index + 1, target + 1, arr); // (i) 뽑는 경우
			doCombination(combArr, n, r, index, target + 1, arr); // (ii) 안 뽑는 경우, r은 뽑지 않았으니 줄어들지 않고, target이 다음으로
																	// 넘어간다(target + 1)
		}
	}
}
