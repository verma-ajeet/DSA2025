package array;

import java.util.Arrays;
import java.util.Comparator;

public class SecondLargest {
	public static void main(String[] args) {
		int[] arr = { -1, 0, 1, 2, -1, -4 };
		System.out.println("===========using stream===============");
		Arrays.stream(arr).boxed().distinct().sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(1)
				.limit(1).forEach(System.out::println);
		System.out.println("==========================");
		getSecondLargest(arr);
		System.out.println("==========================");
		qs(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr) + "second largest is " + arr[arr.length - 2]);
	}

	private static void getSecondLargest(int[] arr) {
		int n = arr.length;
		int largest = Integer.MIN_VALUE, slargest = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > largest) {
				slargest = largest;
				largest = arr[i];
			} else if (arr[i] > slargest && arr[i] < largest) {
				slargest=arr[i];
			}
		}
		System.out.println("usign for loop " + slargest);
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
		for (int j = start; j < end; j++) {
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

}
