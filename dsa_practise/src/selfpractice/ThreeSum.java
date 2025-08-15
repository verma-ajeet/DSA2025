package selfpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 0, 21, 2, 20, 45, 6, 10, 9, 3 };
		int sum = 22;
		getTriplet(arr, sum);
	}

	public static List<List<Integer>> getTriplet(int[] arr, int target) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = arr.length - 1;
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
		return null;

	}
}
