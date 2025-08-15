package array;

import java.util.Arrays;

public class ThreeSumClosest {
	public static void main(String[] args) {
		int[] arr = { -1, 2, 1, -4 };
		int target = 1;
		getClosestSum(arr, target);
	}
//	Find a triplet in an array whose sum is closest to a given number
	private static void getClosestSum(int[] arr, int target) {
		int n = arr.length;
		Arrays.sort(arr);
		int result = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = arr.length - 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum < target) {
					j++;
				} else {
					k--;
				}
				int diffToTarget = Math.abs(sum - target);
				if (diffToTarget < min) {
					result = sum;
					min = diffToTarget;
				}
			}
		}
		System.out.println(result);
	}
}
