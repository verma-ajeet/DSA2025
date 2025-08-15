package Prac;

import java.util.Arrays;

public class MergerSort {
	public static void main(String[] args) {
		int[] arr = { 8, 52, 3, 6, 9, 0, 2 };
		int n = arr.length - 1;
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
//			sort 1st and 2nd part
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
//			merge 2 halves
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];
        for (int i = 0; i < leftSize; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < rightSize; i++) {
            rightArray[i] = arr[mid + i + 1];
        }
		int i=0,j=0,k=left;
		while(i<leftSize&&j<rightSize) {
			if(leftArray[i]<=rightArray[j]) {
				arr[k]=leftArray[i];
				i++;
				k++;
			}else {
				arr[k]=rightArray[j];
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
