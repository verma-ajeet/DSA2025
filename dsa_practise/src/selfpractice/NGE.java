package selfpractice;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
	public static void main(String[] args) {
		int[] arr = { 15, 10, 16, 20, 8, 9, 7, 50 };
		int n = arr.length;
		nextGreaterElement(arr, n);
		System.out.println(Arrays.toString(nextGreaterElement(arr)));
	}

	private static int[] nextGreaterElement(int[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = nge(arr, arr[i]);
		}
		System.out.println("brute code " + Arrays.toString(result));
		return result;
	}

	private static int nge(int[] arr, int curr) {
		for (int j = 0; j < arr.length; j++) {
			if (arr[j] > curr) {
				return arr[j];
			}
		}
		return -1;
	}

	private static void nextGreaterElement(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		for(int i=0;i<n;i++) {
			while(!s.isEmpty() && arr[i]>arr[s.peek()]) {
				arr[s.pop()]=arr[i];
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			arr[s.pop()] = -1;
		}
		System.out.println("optimal using stack "+Arrays.toString(arr));
	}

//	public static int[] nextGreaterElement(int[] nums) {
//		int n = nums.length;
//		int[] result = new int[n];
//
//		for (int i = 0; i < n; i++) {
//			result[i] = findNextGreater(nums, i);
//		}
//
//		return result;
//	}
//
//	private static int findNextGreater(int[] nums, int index) {
//		int currentElement = nums[index];
//
//		for (int i = index + 1; i < nums.length; i++) {
//			if (nums[i] > currentElement) {
//				return nums[i];
//			}
//		}
//
//		return -1; // If no greater element is found
//	}
}
