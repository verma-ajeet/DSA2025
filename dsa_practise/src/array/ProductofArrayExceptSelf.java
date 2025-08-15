package array;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4 };
		int n = arr.length;
		productExceptSelf(arr, n);
		productExceptSelfBySelf(arr, n);
	}

	private static void productExceptSelf(int[] arr, int n) {
		int[] result=new int[n];
		int pref=1;
		for(int i=0;i<n;i++) {
			result[i]=pref;
			pref=pref*arr[i];
		}
		int suff=1;
		for(int i=n-1;i>=0;i--) {
			result[i]=result[i]*suff;
			suff=suff*arr[i];
		}
		System.out.println("optimal sol "+Arrays.toString(result));
	}

//	private static void productExceptSelf(int[] arr, int n) {
//		int[] result=new int[n];
//		int prefix=1;
//		for(int i=0;i<n;i++) {
//			result[i]=prefix;
//			prefix=arr[i]*prefix;
//		}
//		int suffix=1;
//		for(int i=n-1;i>=0;i--) {
//			result[i]=result[i]*suffix;
//			suffix=suffix*arr[i];
//		}
//		System.out.println("optimal sol "+Arrays.toString(result));
//	}

	private static void productExceptSelfBySelf(int[] arr, int n) {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			int prod = 1;
			for (int j = 0; j < n; j++) {
				if (i != j) {
					prod = prod * arr[j];
				}
			}
			result[i] = prod;
		}
		System.out.println(Arrays.toString(result));
	}

//	private static int[] productExceptSelf(int[] arr, int n) {
//		// Result array to store the product except self
//		int[] result = new int[n];
//
//		// Initialize result array with prefix products
//		int prefix = 1;
//		for (int i = 0; i < n; i++) {
//			result[i] = prefix;
//			prefix *= arr[i];
//		}
//		int suffix = 1;
//		for (int i = n - 1; i >= 0; i--) {
//			result[i] *= suffix;
//			suffix *= arr[i];
//		}
//		System.out.println(Arrays.toString(result));
//		return result;
//	}
}
