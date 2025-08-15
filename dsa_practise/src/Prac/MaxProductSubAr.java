package Prac;

public class MaxProductSubAr {
	public static void main(String[] args) {
		int[] arr = { 2, 3, -2, 4 };
		int n = arr.length;
		getMaxProductBrute(arr, n);
		getMaxProductBetter(arr, n);
		getMaxProductOptimal(arr, n);
	}

	private static void getMaxProductBrute(int[] arr, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int prod = 1;
				for (int k = i; k < j; k++) {
					prod = prod * arr[k];
				}
				max = Math.max(max, prod);
			}
		}
		System.out.println(max);
	}

	private static void getMaxProductBetter(int[] arr, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			int prod = 1;
			for (int j = i; j < n; j++) {
				prod = prod * arr[j];
				max = Math.max(max, prod);
			}
		}
		System.out.println(max);
	}

	private static void getMaxProductOptimal(int[] arr, int n) {
		int max = 0, pref = 1, suff = 1;
		for (int i = 0; i < n; i++) {
			if (pref == 0) {
				pref = 1;
			}
			if (suff == 0) {
				suff = 1;
			}
			pref=pref*arr[i];
			suff=suff*arr[n-i-1];
			max=Math.max(max, Math.max(pref, suff));
		}
		System.out.println(max);
	}
}
























