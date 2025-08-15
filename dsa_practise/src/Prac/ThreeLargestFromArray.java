package Prac;

import java.util.Arrays;
import java.util.Comparator;

public class ThreeLargestFromArray {
	public static void main(String[] args) {
		int[] arr = { 8, 52, 3, 6, 9, 0, 2 };
		getThreeLargestUsingStream(arr);
		qs(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.print("using quick sort ");
		for(int i=arr.length-1;i>=arr.length-3;i--) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void qs(int[] arr, int start, int end) {
		if (start < end) {
			int pindex = partition(arr, start, end);
			qs(arr, start, pindex - 1);
			qs(arr, pindex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < arr.length; j++) {
			if (arr[j] < pivot) {
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

	private static void getThreeLargestUsingStream(int[] arr) {
		Object[] topThree = Arrays.stream(arr).boxed().distinct()
				.sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(3).toArray();
		System.out.println("using stream "+Arrays.toString(topThree));
	}
}
