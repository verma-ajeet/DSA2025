package BinarySearch;

import java.util.Arrays;

public class FindMinimumInRotatedArray {
	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		int result = findMin(nums);
		System.out.println("Minimum element: " + result);
		int arr[] = { 5, 6, 1, 2, 3, 4 };
		result = findMin(arr);
		System.out.println("Minimum element: " + result);
		int arr1[] = { 1, 2, 3, 4 };
		result = findMin(arr1);
		System.out.println("Minimum element: " + result);
	}

	private static int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		System.out.println(Arrays.toString(nums));
		while (left < right) {
			int mid = left + (right - left) / 2;
			System.out.println(nums[mid] + " > " + nums[right]);
			if (nums[mid] > nums[right]) {
				// The minimum element is in the right half
				left = mid + 1;
			} else {
				// The minimum element is in the left half or at the mid index
				right = mid;
			}
		}
		// After the loop, left will be pointing to the minimum element
		return nums[left];
	}
}
