package selfpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triplet {
	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		System.out.println(Arrays.toString(arr));
		int n = arr.length;
		int target = 0;
		getTriplet(arr, n, target);
	}

	private static void getTriplet(int[] arr, int n, int target) {
		List<List<Integer>> l = new ArrayList<>();
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < n; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i+1, k = n-1;
			int sum = 0;
			while (j <= k) {
				sum = arr[i] + arr[j] + arr[k];
				if (sum == target) {
					l.add(Arrays.asList(arr[i], arr[j], arr[k]));
					j++;
					k--;
					while (j < k && arr[j] == arr[j + 1]) {
						j++;
					}
					while (j < k && arr[k] == arr[k + 1]) {
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
