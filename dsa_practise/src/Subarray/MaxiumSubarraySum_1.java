package Subarray;

public class MaxiumSubarraySum_1 {
	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = arr.length;
		printMaximumSubarraySum(arr, n);
		// Example 1: Basic Example
		int[] example1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		n = example1.length;
		printMaximumSubarraySum(example1, n); // Output: 6 (subarray: [4, -1, 2, 1])

		// Example 2: Array with All Negative Numbers
		int[] example2 = { -8, -3, -6, -2, -5 };
		n = example2.length;
		printMaximumSubarraySum(example2, n); // Output: -2 (subarray: [-2])

		// Example 3: Array with All Positive Numbers
		int[] example3 = { 2, 4, 6, 8, 10 };
		n = example3.length;
		printMaximumSubarraySum(example3, n); // Output: 30 (subarray: [2, 4, 6, 8, 10])

		// Example 4: Array with Zeros
		int[] example4 = { 0, 1, 2, 0, -1, 2, 1 };
		n = example4.length;
		printMaximumSubarraySum(example4, n); // Output: 5 (subarray: [1, 2, 0, -1, 2])

		// Example 5: Empty Array
		int[] example5 = {};
		n = example5.length;
		printMaximumSubarraySum(example5, n); // Output: 0 (empty array)

		// Example 6: Array with Single Element
		int[] example6 = { -3 };
		n = example6.length;
		printMaximumSubarraySum(example6, n); // Output: -3 (subarray: [-3])

	}

	private static void printMaximumSubarraySum(int[] arr, int n) {
		int max = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
