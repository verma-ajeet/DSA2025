package selfpractice;

import java.util.Stack;

public class Paranthesis {
	public static void main(String[] args) {
		String expression1 = "[()]{}{[()()]()}";
		System.out.println(isBalanced(expression1));
		expression1 = "[()]";
		System.out.println(isBalanced(expression1));
		expression1 = "[()";
		System.out.println(isBalanced(expression1));
		expression1 = "[(])";
		System.out.println(isBalanced(expression1));
		expression1 = "[()]{";
		System.out.println(isBalanced(expression1));
	}

	private static boolean isBalanced(String str) {
		Stack<Character> s = new Stack<>();
		for (Character c : str.toCharArray()) {
			if (c == '(') {
				s.push(')');
			} else if (c == '{') {
				s.push('}');
			} else if (c == '[') {
				s.push(']');
			} else if (s.isEmpty() && s.pop() != c) {
				return false;
			}
		}
		return true;
	}
}
