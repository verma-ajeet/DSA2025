import java.util.Arrays;
import java.util.Stack;

public class PostfixExpression {
	public static void main(String[] args) {
		String exp = "231*+9-";
		System.out.println("postfix evaluation: " + evaluatePostfix(exp));
	}

	private static String evaluatePostfix(String exp) {
		char[] charArray = exp.toCharArray();
		System.out.println(Arrays.toString(charArray));
		Stack<Integer> s = new Stack<>();
		int data = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetterOrDigit(charArray[i])) {
				s.push(charArray[i] - '0');
			} else {
				int num1 = s.pop();
				int num2 = s.pop();
				if (charArray[i] == '+') {
					s.push(num1 + num2);
				} else if (charArray[i] == '-') {
					s.push(num1 - num2);
				} else if (charArray[i] == '*') {
					s.push(num1 * num2);
				} else if (charArray[i] == '/') {
					s.push(num1 / num2);
				}
			}
			System.out.println(s);
		}
		return data + "";
	}
}
