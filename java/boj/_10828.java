package boj;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;


public class _10828 {
	/* 스택 */
	class Stack {
		private List<Integer> stack;

		public Stack() {
			stack = new LinkedList<>();
		}

		public List<Integer> getInstance() {
			return stack;
		}

		private void push(int x) {
			stack.add(x);
		}

		private int pop() {
			if (stack.size() == 0)
				return -1;
			else {
				int value = stack.get(stack.size() - 1);
				stack.remove(stack.size() - 1);
				return value;
			}
		}

		private int size() {
			return stack.size();
		}

		private int empty() {
			return stack.size() == 0 ? 1 : 0;
		}

		private int top() {
			return stack.size() == 0 ? -1 : stack.get(stack.size() - 1);
		}
	}

	public void go() {
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		while (tc-- > 0) {
			String str = sc.nextLine();
			StringTokenizer st = new StringTokenizer(str);
			String instruction = st.nextToken();
			switch (instruction) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				System.out.println(stack.empty());
				break;
			case "top":
				System.out.println(stack.top());
				break;
			}
		}
	}
}
