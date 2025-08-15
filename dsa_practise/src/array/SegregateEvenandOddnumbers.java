package array;

import java.util.Arrays;

public class SegregateEvenandOddnumbers {
	public static void main(String[] args) {
		int[] arr = { 12, 34, 45, 9, 8, 90, 3 };
		segregate(arr);
	}

	private static void segregate(int[] arr) {
		int n = arr.length;
		int left = 0, right = n - 1;
		if (left < right) {
			while (arr[left] % 2 == 0 && left < right)
				left++;

			/* Decrement right index while we see 1 at right */
			while (arr[right] % 2 == 1 && left < right)
				right--;
			if (left < right) {
				/* Swap arr[left] and arr[right] */
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int left, int right) {
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
}
