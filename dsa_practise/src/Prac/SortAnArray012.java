package Prac;

import java.util.Arrays;

public class SortAnArray012 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int n = arr.length;
		sortArray(arr, n);
		System.out.println("==========================================");
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(int[] arr2, int n) {
		int low = 0, mid = 0, high = n-1;
		int i=0;
		while (mid <= high) {
			switch (arr2[mid]) {
			case 0:
				swap(arr2, low, mid);
				mid++;
				low++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr2, mid, high);
				high--;
				break;
			}
		}
		System.out.println(Arrays.toString(arr2));
	}

	private static void swap(int[] arr, int mid, int high) {
		int temp = arr[mid];
		arr[mid] = arr[high];
		arr[high] = temp;
	}
}
