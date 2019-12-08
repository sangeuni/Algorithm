package boj;

import java.util.Scanner;
import java.util.Stack;

public class _9012 {
	/* 괄호 */
	class Parenthesis {
		private Stack<Character> stack;
		private String pString;
		private int left;
		private int right;

		public Parenthesis(String pString) {
			stack = new Stack();
			this.pString = pString;
			this.left = 0;
			this.right = 0;
			pushString(pString);
		}

		private void pushString(String pString) {
			for (int i = pString.length() - 1; i >= 0; i--) {
				stack.push(pString.charAt(i));
			}
		}

		private boolean checkPString() {
			while (!stack.isEmpty()) {
				char ch = stack.pop();
				if (ch == '(') {
					left++;
				} else if (ch == ')') {
					right++;
				}

				if (left < right) {
					return false;
				}
			}
			return true;
		}

		private boolean isVPS() {
			return left == right;
		}
	}

	public void go() {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		while (tc-- > 0) {
			Parenthesis p = new Parenthesis(sc.nextLine());
			String answer = "YES";
			if (!p.checkPString())
				answer = "NO";
			if (!p.isVPS())
				answer = "NO";
			System.out.println(answer);
		}
	}
}
