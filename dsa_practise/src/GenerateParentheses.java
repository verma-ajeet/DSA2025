import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		int n = 3;
		List<String> result = generateParenthesis(n);
//		System.out.println(result);
		n = 2;
		result = generateParenthesis(n);
		System.out.println(result);
	}

	private static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesisHelper(n, n, "", result);
		return result;
	}

	private static void generateParenthesisHelper(int left, int right, String current, List<String> result) {
		if (left == 0 && right == 0) {
			result.add(current);
			return;
		}
		if (left > 0) {
			generateParenthesisHelper(left - 1, right, current + "(", result);
		}
		if (right > left) {
			generateParenthesisHelper(left, right - 1, current + ")", result);
		}
	}
}
