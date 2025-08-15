import java.util.Stack;

public class PostFix {
	public static void main(String[] args) {
		String exp = "100 200 + 2 / 5 * 7 +";
		postFix(exp);
	}

	private static void postFix(String exp) {
		System.out.println(5/5);
		System.out.println(5%5);
		String[] split = exp.split(" ");
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < split.length; i++) {
			if (split[i].matches("\\d+")) {
				s.push(Integer.parseInt(split[i]));
			} else {
				System.out.println(split[i] + " " + s);
				int num2 = s.pop();
				int num1 = s.pop();
				if (split[i].equals("+")) {
					s.push(num1 + num2);
				} else if (split[i].equals("-")) {
					s.push(num1 - num2);
				} else if (split[i].equals("/")) {
					s.push(num1 / num2);
				} else if (split[i].equals("*")) {
					s.push(num1 * num2);
				}
			}
		}
		System.out.println(s);
	}
}
