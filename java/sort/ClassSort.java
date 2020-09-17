package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClassSort {
	static class Company implements Comparable<Company> {
		private String name;
		private int score, rank;

		public Company(String name, int score, int rank) {
			this.name = name;
			this.score = score;
			this.rank = rank;
		}

		@Override
		public int compareTo(Company o) {
			return (this.rank > o.rank) ? 1
					: (this.rank == o.rank)
							? (this.score < o.score) ? 1 : (this.score == o.score) ? (this.name.compareTo(o.name)) : -1
							: -1;
		}

		@Override
		public String toString() {
			return "Company [name=" + name + ", score=" + score + ", rank=" + rank + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		solution(new String[] { "sk", "samsung", "lg" }, new int[] { 100, 100, 300, }, new int[] { 1, 1, 1 });
	}

	static void solution(String[] company, int[] score, int[] rank) {
		List<Company> list = new LinkedList<>();
		for (int i = 0; i < company.length; i++) {
			list.add(new Company(company[i], score[i], rank[i]));
		}
		Collections.sort(list);
		System.out.println(list);
	}
}
