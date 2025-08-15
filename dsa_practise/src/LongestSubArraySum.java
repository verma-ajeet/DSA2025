import java.util.HashMap;

public class LongestSubArraySum {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int n = arr.length;
		int k = 15;
		System.out.println("Length = " + lenOfLongSubarr(arr, n, k));
		System.out.println("Length = " + longestSubarrayOptimal(arr, k));
		;
	}

	private static int lenOfLongSubarr(int[] arr, int n, int k) {
		int maxLength = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
//				System.out.println(sum);
				if (sum == k) {
//					System.out.println(i+" "+j);
					maxLength = Math.max(maxLength, j - i + 1);
				}
				else if(sum>k) {
//					System.out.println(sum);
					break;
				}
			}
		}
		return maxLength;
	}

	private static int longestSubarrayOptimal(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLength = 0;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			if (sum == k) {
				maxLength = i + 1;
			} else if (map.containsKey(sum - k)) {
				maxLength = Math.max(maxLength, i - map.get(sum - k));
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}

		return maxLength;
	}
}
