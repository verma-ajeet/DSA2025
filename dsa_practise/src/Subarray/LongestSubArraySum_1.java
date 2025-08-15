package Subarray;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArraySum_1 {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int n = arr.length;
		int k = 15;
		lenOfLongSubarrBrute(arr, n, k);
		lenOfLongSubarrBetter(arr, n, k);
		lenOfLongSubarrOptimal(arr, n, k);
		// Example 1: Basic Example
		int[] example1 = { 10, 5, 2, 7, 1, 9 };
		int k1 = 15;
		n = example1.length;
		lenOfLongSubarrOptimal(example1, n, k1); // Output: 4 (subarray: [5, 2, 7, 1])

		// Example 2: Array with Negative Numbers
		int[] example2 = { 5, -6, 6, 0, 2, 2, 8, 1 };
		int k2 = 7;
		n = example2.length;
		lenOfLongSubarrOptimal(example2, n, k2); // Output: 5 (subarray: [-6, 6, 0, 2, 2])

		// Example 3: Array with Zeros
		int[] example3 = { 1, 2, 3, 0, 0, 0, 4, 5 };
		int k3 = 7;
		n = example3.length;
		lenOfLongSubarrOptimal(example3, n, k3); // Output: 6 (subarray: [3, 0, 0, 0, 4, 5])

		// Example 4: Array with Repeating Numbers
		int[] example4 = { 8, 3, -7, 4, -1, 2, 1 };
		int k4 = 7;
		n = example4.length;
		lenOfLongSubarrOptimal(example4, n, k4); // Output: 5 (subarray: [8, 3, -7, 4, -1])

		// Example 5: Empty Array
		int[] example5 = {};
		int k5 = 10;
		n = example5.length;
		lenOfLongSubarrOptimal(example5, n, k5); // Output: 0 (empty array)

		// Example 6: Array with Single Element
		int[] example6 = { 7 };
		int k6 = 7;
		n = example6.length;
		lenOfLongSubarrOptimal(example6, n, k6); // Output: 1 (subarray: [7])

	}

	private static void lenOfLongSubarrOptimal(int[] arr, int n, int target) {
		int max = 0, sum = 0;
		HashMap<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == target) {
				max = i + 1;
			} else if (m.containsKey(sum - target)) {
				max = Math.max(max, i - m.get(sum - target));
			}
			m.put(sum, i);
		}
		System.out.println("====================================");
		System.out.println(Arrays.toString(arr) + " target = " + target);
		System.out.println("max length using optimal code " + max);
		System.out.println("====================================");
		System.out.println();
	}

	private static void lenOfLongSubarrBrute(int[] arr, int n, int target) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum += arr[k];
					if (sum == target) {
						max = Math.max(max, j - i - 1);
					}
				}
			}
		}
		System.out.println("length using brute code " + max);
	}

	private static void lenOfLongSubarrBetter(int[] arr, int n, int target) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == target) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		System.out.println("length using brute code " + max);
	}

}
