package Prac;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumSubArray {
	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = arr.length;
		getMaxSum(arr, n);
	}

	private static void getMaxSum(int[] arr, int n) {
		int sum = 0, max = 0;
		int tempstart = 0, start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
				tempstart = i + 1;
			} else {
				start = tempstart;
				max = Math.max(max, sum);
				if (max > sum) {
					end = i;
				}
			}
		}
		Arrays.stream(arr, start, end).forEach(data->{
			System.out.print(data+" ");
		});
		System.out.println();
		System.out.println(max);
		IntStream.range(0, 12).filter(v->v%2==0).forEach(System.out::println);
	}
}
