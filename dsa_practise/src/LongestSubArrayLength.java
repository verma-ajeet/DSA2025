import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayLength {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 1, 1, 1, 1, 3, 3 };
		int n = arr1.length;
		int k = 6;
		getLengthBrute(arr1, n, k);
		getLengthBetterHashing(arr1, n, k);
		getLengthOptimalTwoPointers(arr1, n, k);
	}

	private static void getLengthOptimalTwoPointers(int[] arr1, int n, int k) {
		
	}

	private static void getLengthBetterHashing(int[] arr, int n, int k) {
		int maxLength = 0;
		int sum = 0;
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == k) {
				maxLength = i + 1;
			}
			int remaining = sum - k;
			if (m.containsKey(remaining)) {
				maxLength = Math.max(maxLength, i - m.get(remaining));
			}
			if (!m.containsKey(sum)) {
				m.put(sum, i);
			}
		}
		System.out.println("using hashing " + maxLength);
	}

	private static void getLengthBrute(int[] arr, int n, int k) {
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
		System.out.println("using brute " + maxLength);
	}

}
