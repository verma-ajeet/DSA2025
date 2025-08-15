import java.util.Stack;

public class Paran {
	public static void main(String[] args) {
		String expression1 = "[()]{}{[()()]()}";
		System.out.println(isBalanced(expression1));
	}

	private static boolean isBalanced(String expression1) {
		Stack<Character> s = new Stack<>();
		for(Character c:expression1.toCharArray()) {
			if(c=='(') {
				s.push(')');
			}
			else if(c=='[') {
				s.push(']');
			}
			else if(c=='{') {
				s.push('}');
			}else if(s.isEmpty() || s.pop() != c) {
				return false;
			}
		}
		return s.isEmpty();
	}
}
