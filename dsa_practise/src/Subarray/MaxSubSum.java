package Subarray;

import java.util.Arrays;

public class MaxSubSum {
	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = arr.length;
		getSumBrute(arr, n);
		getSumBetter(arr, n);
		getSumKadanes(arr, n);
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n1 = nums.length;
		getSumKadanes(nums, n1);
		int[] nums1 = { -4, -2, -3, -1 };
		int n2 = nums1.length;
		getSumKadanes(nums1, n2);
	}

	private static void getSumBetter(int[] arr, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum = sum + arr[j];
				max = Math.max(max, sum);
			}
		}
		System.out.println(Arrays.toString(arr) + " " + max);
	}

	private static void getSumBrute(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum = sum + arr[k];
				}
				max = Math.max(max, sum);
			}
		}
		System.out.println(Arrays.toString(arr) + " " + max);
	}

	private static void getSumKadanes(int[] arr, int n) {
		int max = 0, sum = 0;
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
		System.out.println("============================");
		System.out.println("maximum sum is " + max);
		Arrays.stream(arr, start, end).forEach(v -> {
			System.out.print(v + " ");
		});
		System.out.println();
		System.out.println("============================");
	}
}
