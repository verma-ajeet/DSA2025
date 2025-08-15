package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		// Example 1
		int[] nums1 = { -1, 0, 1, 2, -1, -4 };
		System.out.println("Example 1: " + threeSum(nums1));

		// Example 2
		int[] nums2 = {};
		System.out.println("Example 2: " + threeSum(nums2));

		// Example 3
		int[] nums3 = { 0, 0, 0 };
		System.out.println("Example 3: " + threeSum(nums3));

		// Example 4
		int[] nums4 = { -2, -1, -2, -1, -2, -1, 2, 0, 2, 0, 2, 0, 2 };
		System.out.println("Example 4: " + threeSum(nums4));
	}

	private static List<List<Integer>> threeSum(int[] arr) {
		System.out.println(Arrays.toString(arr));
		int n = arr.length;
		List<List<Integer>> l = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			if (i != 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int left = i + 1, right = n - 1;
			while (left < right) {
				int sum = arr[i] + arr[left] + arr[right];
				if (sum == 0) {
					l.add(Arrays.asList(arr[i], arr[left], arr[right]));
					left++;
					right--;
					while (left < right && arr[left] == arr[left - 1]) {
						left++;
					}
					while (left < right && arr[right] == arr[right + 1]) {
						right--;
					}
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return l;
	}
}
