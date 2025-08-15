package Prac;

import java.util.Arrays;

public class MergeS {
	public static void main(String[] args) {
		int[] arr = { 8, 52, 3, 6, 9, 0, 2 };
		int n = arr.length - 1;
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {
//		   int leftSize = mid - left + 1;
//	        int rightSize = right - mid;
		int leftSize = mid - start+1;
		int rightSize = end - mid ;
		
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];
//	      for (int i = 0; i < leftSize; i++) {
//	            leftArray[i] = arr[left + i];
//	        }
//	        for (int i = 0; i < rightSize; i++) {
//	            rightArray[i] = arr[mid + i + 1];
//	        }
		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = arr[start + i];
		}
		for (int i = 0; i < rightSize; i++) {
			rightArray[i] = arr[mid + 1 + i];
		}
		int i = 0, j = 0, k = start;
		while (i < leftSize && j < rightSize) {
			if (leftArray[i] <= rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
				k++;
			} else {
				arr[k] = rightArray[j];
				j++;
				k++;
			}
		}
		while (i < leftSize) {
			arr[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightSize) {
			arr[k] = rightArray[j];
			j++;
			k++;
		}

	}
}
