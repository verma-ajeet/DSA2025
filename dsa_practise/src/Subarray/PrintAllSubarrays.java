package Subarray;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubarrays {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };

		System.out.println("All Subarrays:");
		printAllSubarrays(arr);
	}

	private static void printAllSubarrays(int[] arr) {
		List<List<Integer>> result = new ArrayList<>();
		int n = arr.length;
		System.out.println("no of subarrays " + (n * (n + 1)) / 2);
		for (int start = 0; start < n; start++) {
			for (int end = start; end < n; end++) {
				System.out.print("[ ");
				 List<Integer> subarray = new ArrayList<>();
				for (int k = start; k <= end; k++) {
					subarray.add(arr[k]);
					System.out.print(arr[k] + " ");
				}
				result.add(subarray);
				System.out.println("]");
			}
		}
		System.out.println(result);
	}
}
