package Prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 10, 4, 45, 6, 10, 8 };
		int target = 22;
		int len = arr.length;
		findTriplet(arr, target, len);
	}

	private static void findTriplet(int[] arr, int target, int len) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < len; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i + 1, k = len - 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == target) {
					l.add(Arrays.asList(arr[i], arr[j], arr[k]));
					j++;
					k--;
					while (j < k && arr[j] == arr[j + 1]) {
						j++;
					}
					while (j < k && arr[k] == arr[k - 1]) {
						k--;
					}
				} else if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		System.out.println(l);
	}
}
