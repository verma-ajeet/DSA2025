package recursion;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 4 }; // -> [5,-1,4,-1]
//		ngeusingforloop(arr);
		nge(arr);
	}

	private static void nge(int[] arr) {
		int[] res = new int[arr.length];
		int i = arr.length - 1;
		Stack<Integer> s = new Stack<>();
		s.push(arr[i]);
		res[i] = -1;
		for (i = arr.length - 2; i >= 0; i--) {
			while (!s.isEmpty() && arr[i] > s.peek()) { // if the current element is high then it will pop the smalled
														// element
				s.pop();
			}
			if (s.isEmpty() == true) {
				res[i] = -1;
			} else {
				res[i] = s.peek();
			}
			s.push(arr[i]);
		}
		System.out.println(Arrays.toString(res));
	}

}
