package algorithm;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ObjectSort {
	/*
	 * name : 사전순 정렬 
	 * score : 내림차순 정렬 
	 * rank : 오름차순 정렬
	 */
	static class Company implements Comparable<Company> {
		private String name;
		private int score;
		private int rank;

		public Company(String name, int score, int rank) {
			this.name = name;
			this.score = score;
			this.rank = rank;
		}

		@Override
		public int compareTo(Company o) {
			return (this.rank > o.rank) ? 1
					: (this.rank == o.rank)
							? (this.score < o.score) ? 1 : (this.score == o.score) ? this.name.compareTo(o.name) : -1
							: -1;
		}

		@Override
		public String toString() {
			return "Company [name=" + name + ", score=" + score + ", rank=" + rank + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		solution(new String[] { "sk", "samsung", "lg" }, new int[] { 100, 20, 30 }, new int[] { 1, 1, 1 });
	}

	static String[] solution(String[] name, int[] score, int[] rank) {
		String[] answer = new String[name.length];
		List<Company> list = new LinkedList<>();
		for (int i = 0; i < name.length; i++) {
			list.add(new Company(name[i], score[i], rank[i]));
		}
		Collections.sort(list);
		for (Company c : list) {
			System.out.println(c);
		}
		return answer;
	}
}
