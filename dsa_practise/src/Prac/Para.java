package Prac;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Para {
	public static void main(String[] args) {
		String expression1 = "[()]{}{[()()]()}";
		System.out.println(isBalanced(expression1));
		expression1 = "[()]";
		System.out.println(isBalanced(expression1));
		expression1 = "[()";
		System.out.println(isBalanced(expression1));
		expression1 = "[(])";
		System.out.println(isBalanced(expression1));
		int[] arr = { 1, 0, 0, 1, 1, 1, 0, 0, 0 };
		Map<Boolean, List<Integer>> collect = Arrays.stream(arr).boxed()
				.collect(Collectors.partitioningBy(i->i==0));
		System.out.println(collect);
		int[] array = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i->i==0))
			.values().stream().flatMapToInt(list->list.stream().mapToInt(Integer::intValue))
			.toArray();
		System.out.println(Arrays.toString(array));
		movezeros(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void movezeros(int[] arr) {
		int zeroIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[zeroIndex];
				arr[zeroIndex] = temp;
				zeroIndex++;
//				System.out.println(Arrays.toString(arr));
			}
		}
	}

	private static boolean isBalanced(String str) {
		if (str.length() % 2 != 0) {
			return false;
		}
		Stack<Character> s = new Stack<>();
		for (Character c : str.toCharArray()) {
			if (c == '(') {
				s.push(')');
			} else if (c == '{') {
				s.push('}');
			} else if (c == '[') {
				s.push(']');
			} else if (s.isEmpty() || s.pop() != c) {
				return false;
			}
		}
		return true;
	}
}
