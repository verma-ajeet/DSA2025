package Subarray;

import java.util.Arrays;

public class MaxProductSubArray {
	public static void main(String[] args) {
//		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int[] arr = { 2, 3, -2, 4 };
		int n = arr.length;
		getMaxSum(arr, n);
		getMaxProductBrute(arr, n); // n3
		getMaxProductBetter(arr, n); // n2
		getMaxProductOptimal(arr, n); // n
		
		int[] array= { -2, 0, -1};
		getMaxProductBrute(array, array.length);
		getMaxProductOptimal(array, array.length);
		
		// Example 1: Array with Positive Numbers
		int[] positiveArray = { 2, 3, 4, 5 };
		getMaxProductOptimal(positiveArray, positiveArray.length); // Output: 120

		// Example 2: Array with Negative Numbers
		int[] negativeArray = { -2, -3, -4, -5 };
		getMaxProductOptimal(negativeArray, negativeArray.length); // Output: 120

		// Example 3: Array with Both Positive and Negative Numbers
		int[] mixedArray = { -2, 3, -4, 5 };
		getMaxProductOptimal(mixedArray, mixedArray.length); // Output: 120

		// Example 4: Array with Zeros
		int[] zeroArray = { 2, 0, 4, 5, 0 };
		getMaxProductOptimal(zeroArray, zeroArray.length); // Output: 20

		// Example 5: Empty Array
		int[] emptyArray = {};
		getMaxProductOptimal(emptyArray, emptyArray.length); // Output: Integer.MIN_VALUE (Empty array)

		// Example 6: Array with Single Element
		int[] singleElementArray = { 5 };
		getMaxProductOptimal(singleElementArray, singleElementArray.length); // Output: 5

		 // Example 1: Normal Array
        int[] normalArray = {2, -3, 4, -2, 5};
        getMaxProductOptimal(normalArray, normalArray.length); // Output: 240

        // Example 2: Array with a Zero Product Subarray
        int[] zeroProductArray = {2, 0, 4, -2, 5};
        getMaxProductOptimal(zeroProductArray, zeroProductArray.length); // Output: 4 (subarray: {2, 0, 4})

        // Example 3: Array with Repeating Zeros
        int[] repeatingZerosArray = {0, 0, 0, 0};
        getMaxProductOptimal(repeatingZerosArray, repeatingZerosArray.length); // Output: 0

        // Example 4: Array with All Negative Numbers
        int[] allNegativeArray = {-2, -3, -4, -5};
        getMaxProductOptimal(allNegativeArray, allNegativeArray.length); // Output: 120

        // Example 5: Array with Only One Element
        int[] singleElementArray2 = {7};
        getMaxProductOptimal(singleElementArray2, singleElementArray2.length); // Output: 7

        // Example 6: Large Array with Random Numbers
        int[] largeRandomArray = {2, -3, 4, -2, 5, 1, 7, -8, 9, 10, -2, 3, -1, 2};
        getMaxProductOptimal(largeRandomArray, largeRandomArray.length); // Output: 151200
  
	}

	private static void getMaxProductOptimal(int[] arr, int n) {
		int pre = 1, suff = 1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (pre == 0) {
				pre = 1;
			}
			if (suff == 0) {
				suff = 1;
			}
			pre = pre * arr[i];
			suff = suff * arr[n - i - 1];
			max = Math.max(max, Math.max(pre, suff));
		}
		System.out.println(Arrays.toString(arr)+" "+max);
	}

	private static void getMaxProductBrute(int[] arr, int n) {
		int maxProd = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int prod = 1;
				for (int k = i; k < j; k++) {
					prod *= arr[k];
				}
				maxProd = Math.max(maxProd, prod);
			}
		}
		System.out.println("maxProd " + maxProd);
	}

	private static void getMaxProductBetter(int[] arr, int n) {
		int maxProd = 0;
		for (int i = 0; i < n; i++) {
			int prod = 1;
			for (int j = i; j < n; j++) {
				prod *= arr[j];
				maxProd = Math.max(maxProd, prod);
			}
		}
		System.out.println("maxProd " + maxProd);
	}

	private static void getMaxSum(int[] arr, int n) {
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum < 0) {
				sum = 0;
			} else {
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
}
