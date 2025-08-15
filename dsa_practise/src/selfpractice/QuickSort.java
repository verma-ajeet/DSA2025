package selfpractice;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 10, 62, 8, 6, 2, 0 };
		int n = arr.length - 1;
		qs(arr, 0, n);
		System.out.println(Arrays.toString(arr));
	}

	private static void qs(int[] arr, int low, int high) {
		if (low < high) {
			int pindex = partition(arr, low, high);
			qs(arr, low, pindex - 1);
			qs(arr, pindex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}
}
