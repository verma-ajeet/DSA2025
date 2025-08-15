package Subarray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsKExamples {
	public static void main(String[] args) {
		// Example 1: Basic Example
		int[] example1 = { 1, 2, 3, 4, 5 };
		int k1 = 9;
		printSubarrayCount(example1, k1); // Output: 2 (subarrays: [2, 3, 4] and [4, 5])

		// Example 2: Array with Negative Numbers
		int[] example2 = { 3, 4, 7, 2, -3, 1, 4, 2 };
		int k2 = 7;
		printSubarrayCount(example2, k2); // Output: 4 (subarrays: [3, 4], [7], [2, -3, 1, 4], [4, 2])

		// Example 3: Array with Zeros
		int[] example3 = { 1, 0, 1, 0, 1 };
		int k3 = 2;
		printSubarrayCount(example3, k3); // Output: 5 (subarrays: [1], [1, 0, 1], [1, 0, 1, 0, 1], [0, 1], [1])

		// Example 4: Array with Repeating Numbers
		int[] example4 = { 3, 2, 3, 2, 1, 2, 1 };
		int k4 = 6;
		printSubarrayCount(example4, k4); // Output: 10 (subarrays: [3, 2, 3], [2, 3, 2], [3, 2], [2, 3], [3, 2, 1], [2,
											// 1], [3, 2, 1, 2], [2, 1, 2], [1, 2, 1], [2, 1])

		// Example 5: Empty Array
		int[] example5 = {};
		int k5 = 5;
		printSubarrayCount(example5, k5); // Output: 0 (empty array)

		// Example 6: Array with Single Element
		int[] example6 = { 7 };
		int k6 = 7;
		printSubarrayCount(example6, k6); // Output: 1 (subarray: [7])

	}

	private static void printSubarrayCount(int[] arr, int target) {
		List<List<Integer>> l = new ArrayList<>();
		int sum = 0, count = 0;
		int n = arr.length;
		Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 1);
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (m.containsKey(sum - target)) {
				count += m.getOrDefault(sum - target, 0);
			}
			m.put(sum, m.getOrDefault(sum, 0) + 1);
		}
		System.out.println(count);
	}
}
