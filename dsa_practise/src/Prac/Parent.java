package Prac;

import java.util.Stack;

public class Parent {
	public static void main(String[] args) {
		String expression1 = "[()]{}{[()()]()}";
		System.out.println("true = "+isBalanced(expression1));
		expression1 = "[()]";
		System.out.println("true = "+isBalanced(expression1));
		expression1 = "[()";
		System.out.println("false = "+isBalanced(expression1));
		expression1 = "[(])";
		System.out.println("false = "+isBalanced(expression1));
	}

	private static boolean isBalanced(String input) {
		Stack<Character> s=new Stack<>();
		if(input.length()%2!=0) {
			return false;
		}
		for(Character c: input.toCharArray()) {
			if(c=='(') {
				s.push(')');
			}
			else if(c=='[') {
				s.push(']');
			}
			else if(c=='{') {
				s.push('}');
			}else if(s.isEmpty() || s.pop()!=c) {
				return false;
			}
		}
		return true;
	}
}
