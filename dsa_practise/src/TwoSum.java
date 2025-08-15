import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 5, 8, 11 };
		int k = 14;
		int n = arr.length;
		int[] twoSumBrute = TwoSumBrute(arr, n, k);
		System.out.println(Arrays.toString(twoSumBrute));
		System.out.println("better " + Arrays.toString(TwoSumBetter(arr, n, k)));
		System.out.println("optimal " + Arrays.toString(TwoSumOptimalTwoPointer(arr, n, k)));
		System.out.println("optimal try " + Arrays.toString(TwoSumOptimalTwoPointertry(arr, n, k)));
		int[] arr1 = { 3, 2, 4 };
		n = arr1.length;
		k = 6;
		System.out.println(
				Arrays.toString(arr1) + " -> " + Arrays.toString(TwoSumOptimalTwoPointer(arr1, n, k)) + " = " + k);
		System.out.println(Arrays.toString(TwoSumBrute(arr1, n, k)));
	}

	private static int[] TwoSumOptimalTwoPointertry(int[] arr, int n, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		int sum = 0;
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < n; i++) {
			sum = k - arr[i];
			if (m.containsKey(sum)) {
				System.out.println(arr[m.get(sum)]+" "+arr[i]);
				return new int[] { m.get(sum), i };
			} else {
				m.put(arr[i], i);
			}
		}
		return new int[] { 0, 0 };
	}

	private static int[] TwoSumOptimalTwoPointer(int[] arr, int n, int k) {
		int[] result = { 0, 0 };
		Arrays.sort(arr);
		int left = 0, right = n - 1;
		while (left < right) {
			int sum = arr[left] + arr[right];
			if (sum == k) {
				result[0] = left;
				result[1] = right;
				return result;
			} else if (k > sum) {
				left++;
			} else {
				right--;
			}
			System.out.println(left + " " + right);
		}
		return result;
	}

	private static int[] TwoSumBetter(int[] arr, int n, int k) {
		int[] result = { 0, 0 };
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int remaining = k - arr[i];
			if (!m.containsKey(remaining)) {
				m.put(arr[i], i);
			} else {
				result[0] = i;
				result[1] = m.get(remaining);
			}
		}
		return result;
	}

	private static int[] TwoSumBrute(int[] nums, int n, int target) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
//            	if(i==j) {
//            		continue;
//            	}

				int sum = nums[i] + nums[j];
				if (sum == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0, 0 };
	}
}
