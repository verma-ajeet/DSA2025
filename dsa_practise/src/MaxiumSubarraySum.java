import java.util.ArrayList;
import java.util.List;

public class MaxiumSubarraySum {
	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = arr.length;
		getSumBrute(arr, n);
		getSumKadanes(arr, n);
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n1 = nums.length;
		getSumKadanes(nums, n1);
		int[] nums1 = { -4, -2, -3, -1 };
		int n2 = nums1.length;
		getSumKadanes(nums1, n2);
	}

	private static void getSumKadanes(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int tempstart = 0, start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
				tempstart = i + 1;
			}
			if (sum > max) {
				max = sum;
				start = tempstart;
				end = i;
			}
		}
		List<Integer> l = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			l.add(arr[i]);
		}
		System.out.println(l);
		System.out.println("using kadanes algo " + max);
	}

	private static void getSumBrute(int[] arr, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}

}
