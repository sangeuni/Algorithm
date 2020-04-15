package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
	public static List<Integer> numList = new ArrayList<>(Arrays.asList(100, 40, 60, 75, 77, 34, 51, 24, 24, 37, 88));
	public static void main(String[] args) {
		List<Integer> result = sort(numList);
		System.out.println(result);
	}

	static List<Integer> sort(List<Integer> numList) {
		if (numList.size() > 1) {
			return merge(sort(numList.subList(0, numList.size() / 2)),
					sort(numList.subList(numList.size() / 2, numList.size())));
		} else {
			return numList;
		}
	}

	static List<Integer> merge(List<Integer> leftList, List<Integer> rightList) {
		List<Integer> mergeList = new ArrayList<>();
		int rightIndex = 0;
		for (int left : leftList) {
			while (rightList.size() > rightIndex && left > rightList.get(rightIndex)) {
				mergeList.add(rightList.get(rightIndex));
				rightIndex++;
			}
			mergeList.add(left);
		}

		for (int i = rightIndex; i < rightList.size(); i++) {
			mergeList.add(rightList.get(i));
		}
		return mergeList;
	}
}
