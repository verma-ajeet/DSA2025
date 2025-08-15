package Subarray;

import java.util.Arrays;
import java.util.HashMap;

public class CountSubArraySumEqualSK {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, -3, 1, 1, 1, 4, 2, -3 };
		int target = 3;
		getCountBrute(arr, target);
		getCountBetter(arr, target);
		getCountOptimal(arr, target);
		int[] arr1 = { 3, 1, 2, 4 };
		int k = 6;
		System.out.println();
		System.out.println("======================");
		getCountBrute(arr1, k);
		getCountBetter(arr1, k);
		getCountOptimal(arr1, k);
	}

	private static void getCountOptimal(int[] arr, int target) {
		int count = 0;
		int sum = 0, n = arr.length;
		HashMap<Integer, Integer> m = new HashMap<>();
		m.put(0,1);
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (m.containsKey(sum - target)) {
				count += m.getOrDefault(sum - target, 0);
			}
			m.put(sum, m.getOrDefault(sum, 0) + 1);
		}
		System.out.println(Arrays.toString(arr)+" optimal " + count);
	}

	private static void getCountBetter(int[] arr, int target) {
		int n = arr.length, count = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				sum += arr[j];
				if (sum == target)
					count++;
			}
		}
		System.out.println("better sol "+count);
	}

	private static void getCountBrute(int[] arr, int target) {
		int n = arr.length;
		int  count = 0;
		for (int i = 0; i < n; i++) {
			for(int j=i;j<n;j++) {
				int sum=0;
				for(int k=i;k<=j;k++) {
					sum=sum+arr[k];
				}
				if(sum==target) {
					count++;
				}
			}
		}
		System.out.println("brute code "+count);
	}
}
