package selfpractice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
	public static void main(String[] args) {
		int n = 3;
		generateParanthes(3);
	}

	private static void generateParanthes(int n) {
		List<String> result = new ArrayList<>();
		generate(n, n, "", result);
		System.out.println(result);
	}

	private static void generate(int left, int right, String current, List<String> result) {
		if (left == 0 && right == 0) {
			result.add(current);
			return;
		}
		if (left > 0) {
			generate(left - 1, right, current + "(", result);
		}
		if (right > left) {
			generate(left, right - 1, current + ")", result);
		}
	}
}
