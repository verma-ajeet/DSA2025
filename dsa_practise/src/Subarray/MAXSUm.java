package Subarray;

import java.util.Arrays;

import javax.xml.transform.Templates;

public class MAXSUm {
	public static void main(String[] args) {
		// Example 1
		int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println("Example 1: " + maxSubArray(nums1));
		// Output: 6

		// Example 2
		int[] nums2 = { 1, 2, 3, 4, -1, -2, 5, -3 };
		System.out.println("Example 2: " + maxSubArray(nums2));
		// Output: 15

		// Example 3
		int[] nums3 = { -1, -2, -3, -4, -5 };
		System.out.println("Example 3: " + maxSubArray(nums3));
		// Output: -1

		// Example 4
		int[] nums4 = { -1, 3, -2, 4, -1, 2, 1, -5, 4 };
		System.out.println("Example 4: " + maxSubArray(nums4));
		// Output: 7

		// Example 5
		int[] nums5 = { 5, -3, 4, -2, 8, -1 };
		System.out.println("Example 5: " + maxSubArray(nums5));
		// Output: 16
	}

	private static int maxSubArray(int[] arr) {
		int n = arr.length;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int tempStart = 0, start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
				tempStart = i + 1;
			} else {
				start = tempStart;
				max = Math.max(max, sum);
				if (max > sum) {
					end = i;
				}
			}
		}
		Arrays.stream(arr, start, end).forEach(v -> {
			System.out.print(v + " ");
		});
		return max;
	}
}

//Example 1: 6
//Example 2: 12
//Example 3: -1
//Example 4: 7
//Example 5: 12