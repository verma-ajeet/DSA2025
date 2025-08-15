package LL;

import java.util.Arrays;

public class qs {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 2, 69, 7, 5, 1, 2, 1, 8 };
		int n = arr.length;
		quicksort(arr, 0, n - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void quicksort(int[] arr, int start, int end) {
		if (start < end) {
			int pindex = partition(arr, start, end);
			quicksort(arr, start, pindex - 1);
			quicksort(arr, pindex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;
		return i + 1;
	}
}
