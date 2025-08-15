package selfpractice;

import java.util.Arrays;

public class reverseArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int n = arr.length;
		System.out.println("before " + Arrays.toString(arr));
		reverse(arr, n - 1);
		System.out.println();
		System.out.println("before recurrsion"+Arrays.toString(arr));
		reverseRecursion(arr, 0, n - 1);
		System.out.println("after recurrsion"+Arrays.toString(arr));
		System.out.println();
		System.out.println("before recurrsion"+Arrays.toString(arr));
		reverseRecursionUsingOnePointer(arr, 0);
		System.out.println("after recurrsion"+Arrays.toString(arr));
	}

	private static void reverseRecursionUsingOnePointer(int[] arr, int start) {
		if(start>=arr.length/2) {
			return;
		}
		swap(arr,start,arr.length-1-start);
		reverseRecursionUsingOnePointer(arr, start+1);
	}

	private static void reverseRecursion(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}
		swap(arr, left, right);
		reverseRecursion(arr, left+1, right-1);
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	private static void reverse(int[] arr, int n) {
		for (int i = 0; i < n / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[n - i];
			arr[n - i] = temp;
		}
		System.out.println("after " + Arrays.toString(arr));
	}
}
