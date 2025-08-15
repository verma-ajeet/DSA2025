import java.util.Arrays;

public class RearrangePosAndNeg {
	public static void main(String[] args) {
		int[] arr = { 2, 3, -1, -3, 4, -5 };
		int n = arr.length;
		rearrange(arr, n);
		rearrangeOptimal(arr, n);
		int[] arr1 = { -1, 2, 3, 4, -3, 1 };
		int n1 = arr1.length;
		rearrangeNotEqualPosAndNeg(arr1, n1);
	}

	private static void rearrangeNotEqualPosAndNeg(int[] arr1, int n1) {
		int negcount = 0, poscount = 0;
		for (int value : arr1) {
			if (value < 0) {
				negcount++;
			} else {
				poscount++;
			}
		}
		int j = 0;
		int[] res = new int[n1];
		int min = Math.min(poscount, negcount);
		for (int i = 0; i < n1; i++) {
			if (j < min) {
				if (arr1[i] < 0) {
					res[i * 2 + 1] = arr1[i];
					j++;
				} else {
					res[i * 2] = arr1[i];
					j++;
				}
			} else {
				res[j] = arr1[i];
				j++;
			}
		}
		System.out.println("unequal result "+Arrays.toString(res));
	}

	private static void rearrangeOptimal(int[] arr, int n) {
		int[] res = new int[n];
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				res[j * 2 + 1] = arr[i];
				j++;
			} else {
				res[k * 2] = arr[i];
				k++;
			}
		}
		System.out.println(Arrays.toString(res));
	}

	private static void rearrange(int[] arr, int n) {
		int[] negArray = null;
		int[] posArray = null;
		if (n % 2 == 0) {
			posArray = new int[n / 2];
			negArray = new int[n / 2];
		}
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] < 0) {
				negArray[j] = arr[i];
				j++;
			} else {
				posArray[k] = arr[i];
				k++;
			}
		}
		for (int i = 0; i < n / 2; i++) {
			arr[i * 2] = posArray[i];
			arr[i * 2 + 1] = negArray[i];
		}
		System.out.println(Arrays.toString(arr));
	}
}
