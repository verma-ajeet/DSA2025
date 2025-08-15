import java.util.Stack;

public class Para {
	public static void main(String[] args) {
		String expression1 = "[()]{}{[()()]()}";
		System.out.println(checkPara(expression1));
	}

	private static boolean checkPara(String expression1) {
		Stack<Character> s = new Stack<>();
		for (char c : expression1.toCharArray()) {
			if (c == '(') {
				s.push(')');
			} else if (c == '{') {
				s.push('}');
			} else if (c == '[') {
				s.push(']');
			}else if(s.isEmpty() || s.pop()!=c) {
				return false;
			}
		}
		return s.isEmpty();
	}
}
