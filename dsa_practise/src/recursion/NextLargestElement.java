package recursion;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElement {
	public static void main(String[] args) {
		long[] arr = { 1, 5, 2, 4 };
		System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
	}

	public static long[] nextLargerElement(long[] arr, int n) {
		long[] ans = new long[arr.length];
		int i = arr.length - 1;
		ans[i] = -1;
		System.out.println(Arrays.toString(ans));
		Stack<Long> stk = new Stack<>();
		stk.push(arr[i]);
		System.out.println("stk "+stk);
		for (i = arr.length - 2; i >= 0; i--) {
			System.out.println(i);
			while (!stk.isEmpty() && arr[i] > stk.peek())
				stk.pop();
			ans[i] = (stk.isEmpty() == true) ? -1 : stk.peek();
			stk.push(arr[i]);
			System.out.println(stk+" = "+Arrays.toString(ans));
		}
		return ans;
	}
}