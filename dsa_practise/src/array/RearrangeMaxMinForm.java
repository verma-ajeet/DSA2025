package array;

import java.util.Arrays;

public class RearrangeMaxMinForm {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		rearrange(arr);
	}

	private static void rearrange(int[] arr) {
		int n = arr.length;
		int[] res = new int[n];
		int left = 0, right = n - 1;
		for (int i = 0; i < n; i++) {
//			res[i*2+1]=arr[n-i-1];
//			res[i*2]=arr[i];
			if (i % 2 == 0) {
				res[i] = arr[right];
				right--;
			} else {
				res[i] = arr[left];
				left++;
			}
		}
		System.out.println(Arrays.toString(res));
	}

}
