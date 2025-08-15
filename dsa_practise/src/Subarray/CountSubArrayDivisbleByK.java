package Subarray;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayDivisbleByK {
	public static void main(String[] args) {
		int[] arr = { 4, 5, 0, -2, -3, 1 };
		int divisible = 5;
		getCountBrute(arr, divisible);
		getCountBetter(arr, divisible);
		getCountOptimal(arr, divisible);
	}

	private static void getCountOptimal(int[] arr, int divisible) {
		int n = arr.length;
		Map<Integer, Integer> sumFrequency = new HashMap<>();
		sumFrequency.put(0, 1);
		int sum = 0, count = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + arr[i]) % divisible;
			if (sum < 0) {
				// Handle negative mod results in Java
				sum += divisible;
			}
			if (sumFrequency.containsKey(sum)) {
				count += sumFrequency.get(sum);
			}
//			updatee the frequency of the current sum
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
		}
		System.out.println("optimal code "+count);
	}

	private static void getCountBetter(int[] arr, int divisble) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum % divisble == 0) {
					count++;
				}
			}
		}
		System.out.println("better code " + count);
	}

	private static void getCountBrute(int[] arr, int divisble) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum % divisble == 0) {
					count++;
				}
			}
		}
		System.out.println("brute code " + count);
	}
}
