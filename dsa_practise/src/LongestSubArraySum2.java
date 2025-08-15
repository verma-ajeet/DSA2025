import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySum2 {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int[] arr1 = { 1, 2, 3, 1, 1, 1, 1, 3, 3 };
		int n = arr.length;
		int k = 15;
		System.out.println("Length = " + lenOfLongSubarr(arr, n, k));
		System.out.println("Length = " + lenOfLongSubarrUsingHash(arr, n, k));
		System.out.println("self prac brute Length = " + lenOfLongSubarrPracBrute(arr, n, k));
		System.out.println("self prac better Length using hashmap = " + lenOfLongSubarrPracBetter(arr, n, k));
		System.out.println(
				"self prac optimal Length using two pointer= " + lenOfLongSubarrPracOptimalTwoPointer(arr, n, k));
		System.out.println("self prac optimal Length using two pointer= "
				+ lenOfLongSubarrPracOptimalTwoPointer(arr1, arr1.length, 6));
	}

	private static int lenOfLongSubarrPracOptimalTwoPointer(int[] arr, int n, int k) {
		int maxLength = 0, sum = 0;
		int i = 0, j = 0;
		while (i < n && j < n) {
			sum += arr[j];
			while (j >= i && sum > k) {
				sum -= arr[i];
				i++;
			}
			if (k > sum) {
				j++;
			}
			if (sum == k) {
				maxLength = Math.max(maxLength, j - i + 1);
				j++;
			}
		}
		return maxLength;
	}

	private static int lenOfLongSubarrPracBetter(int[] arr, int n, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		int sum = 0;
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == k) {
				maxLength = Math.max(maxLength, i + 1);
			}
			int remaining = sum - k;
			if (m.containsKey(remaining)) {
				maxLength = Math.max(maxLength, i - m.get(remaining));
			}
			if (!m.containsKey(sum)) {
				m.put(sum, i);
			}
		}
		return maxLength;
	}

	private static int lenOfLongSubarrPracBrute(int[] arr, int n, int k) {
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == k) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}
		return maxLength;
	}

	private static int lenOfLongSubarrUsingHash(int[] arr, int n, int k) {
		int sum = 0;
		int maxLength = 0;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == k) {
				maxLength = Math.max(maxLength, i + 1);
			}
			int remaining = sum - k;
			if (m.containsKey(remaining)) {
				int len = i - m.get(remaining);
				maxLength = Math.max(maxLength, len);
			}
			if (!m.containsKey(sum)) {
				m.put(sum, i);
			}
		}
		System.out.println(m);
		return maxLength;
	}

	private static int lenOfLongSubarr(int[] arr, int n, int k) {
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == k) {
					maxLength = Math.max(maxLength, j - i + 1);
				}
			}
		}
		return maxLength;
	}
}
