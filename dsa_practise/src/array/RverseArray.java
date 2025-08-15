package array;

import java.util.Arrays;

public class RverseArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate(arr, k);
		System.out.println(Arrays.toString(arr));
	}

	public static void rotate(int[] arr, int k) {
		int n = arr.length;
		k = k % arr.length;

		reverse(arr, 0, arr.length - k-1);
		System.out.println(Arrays.toString(arr));
		reverse(arr, arr.length - k, n-1);
		System.out.println(Arrays.toString(arr));
		reverse(arr, 0, n-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void reverse(int[] arr, int start, int end) {
		while(start<end) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
}
