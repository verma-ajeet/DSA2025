package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NLE {
	public static void main(String[] args) {
		int arr[] = { 11,2, 13, 21, 3 };
		int n = arr.length;
		printNGE(arr, n);
	}

	private static void printNGE(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!s.isEmpty() && arr[i] > s.peek()) {
				map.put(s.pop(), arr[i]);
			}
			s.push(arr[i]);
		}
		System.out.println(map);
		for(int i=0;i<arr.length;i++) {
			arr[i]=map.getOrDefault(arr[i], -1);
		}
		System.out.println(Arrays.toString(arr));
	}
}
