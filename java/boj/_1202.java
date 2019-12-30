package boj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


public class _1202 {
	/* 보석 도둑 */
	int N, K;

	class Gem implements Comparable<Gem> {
		private int M, V;

		public Gem(int M, int V) {
			this.M = M;
			this.V = V;
		}

		@Override
		public int compareTo(Gem o) {	// 비교 기준을 무게로 삼기
			return this.M - o.M;
		}

	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		Gem[] gems = new Gem[N];
		int[] bags = new int[K];
		Queue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		int m, v;
		for (int i = 0; i < N; i++) {
			m = sc.nextInt();
			v = sc.nextInt();
			gems[i] = new Gem(m, v);
		}
		int c;
		for (int i = 0; i < K; i++) {
			c = sc.nextInt();
			bags[i] = c;
		}

		Arrays.sort(gems);	// 무게 순으로 오름차순 정렬
		Arrays.sort(bags);	

		long answer = 0;	// V(100만) X K(30만) 
		int j = 0;
		for (int i = 0; i < K; i++) {
			while(j < N && gems[j].M <= bags[i]) {
				q.offer(gems[j].V);	// 가방에 들어갈 수 있는 보석만 enqueue
				j++;
			}
			if(!q.isEmpty())
				answer += q.poll();
		}

		System.out.println(answer);
	}
}
