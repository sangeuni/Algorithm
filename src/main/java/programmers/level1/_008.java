package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;

public class _008 {
	/*
	 * Level1 - 문자열 내 마음대로 정렬하기
	 */
	public static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		Word[] word = new Word[strings.length];
		for (int i = 0; i < strings.length; i++) {
			word[i] = new Word(strings[i], n);
		}

		Arrays.sort(word, new Comparator<Word>() {
			@Override
			public int compare(Word o1, Word o2) {
				if (o1.pivot.equals(o2.pivot))
					return o1.string.compareTo(o2.string);
				return o1.pivot.compareTo(o2.pivot);
			}
		});

		for (int i = 0; i < word.length; i++) {
			answer[i] = word[i].string;
		}
		return answer;
	}

	public static class Word {
		private String string;
		private String pivot;

		public Word() {
			string = pivot = "";
		}

		public Word(String string, int n) {
			this.string = string;
			this.pivot = String.valueOf(string.charAt(n));
		}

	}
}
