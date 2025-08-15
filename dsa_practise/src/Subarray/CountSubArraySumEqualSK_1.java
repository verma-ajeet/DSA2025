package Subarray;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumEqualSK_1 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
		int target = 3;
		getCountBrute(arr, target);
		getCountBetter(arr, target);
		getCountOptimal(arr, target);
	}

	private static void getCountOptimal(int[] arr, int target) {
		int count = 0;
		Map<Integer, Integer> m = new HashMap<>();
		m.put(0, 1);
		int n = arr.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if(m.containsKey(sum-target)) {
				count+=m.getOrDefault(sum-target,0 );
			}
			m.put(sum, m.getOrDefault(sum, 0) + 1);
		}
		System.out.println("optimal code = " + count);
	}

	private static void getCountBetter(int[] arr, int target) {
		int n = arr.length, count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == target) {
					count++;
				}
			}
		}
		System.out.println("better code = " + count);
	}

	private static void getCountBrute(int[] arr, int target) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum == target) {
					count++;
				}
			}
		}
		System.out.println("brute code = " + count);
	}
}
