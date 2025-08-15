import java.util.Arrays;

public class FindMissingNumber {
	public static void main(String[] args) {
		int[] arr = { 2, 0, 1 };
		int num = findMissingUsingBruteCode(arr);
		System.out.println(num);
		int num1 = findMissingUsingXOR(arr);
		System.out.println(Arrays.toString(arr) + " missing is " + num1);
		int[] arr1 = { 11, 12, 14, 15 };
		int num11 = findMissingUsingXOR(arr1);
		System.out.println(Arrays.toString(arr1) + " missing is " + num11);
		int num12 = findMissing(arr1);
		System.out.println(Arrays.toString(arr1) + " missing is " + num11);
		int num2 = findMissingUsingSum(arr);
		System.out.println(num2);
	}

	private static int findMissing(int[] arr1) {
		Arrays.sort(arr1);
		int n = arr1.length;
		int missing=0;
		for (int i = 0; i < n; i++) {
			if (arr1[i + 1] - arr1[i] == 1) {
                missing=arr1[i+1];
			}else {
				missing++;
				break;
			}
		}
		System.out.println(Arrays.toString(arr1)+" missing "+missing);
		return missing;
	}

//  TC -> O(n^2)  SC = O(1)
	private static int findMissingUsingBruteCode(int[] arr) {
		int n = arr.length + 1;
		for (int i = 0; i <= n; i++) {
			boolean flag = false;
			for (int num : arr) {
				if (i == num) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				return i;
			}
		}
		return -1;
	}

//	===========================================================================================================================
//  2^2 = 0
//	3^3 = 0
//	2^2^3^3 = 0
//	0^4 = 4
//	2^2^3^3^4 = 4

	private static int findMissingUsingXOR(int[] arr) {
		int n = arr.length;
		int firstElement = arr[0];
		int xorAll = 0;
		for (int i = 0; i <= n; i++) {
			xorAll ^= firstElement;
			System.out.println(firstElement);
			firstElement++;

		}
//      therefore xorAll = > 0^1^2^3
		int xorArr = 0;
		for (int i = 0; i < n; i++) {
			xorArr ^= arr[i];
		}
//		here also xorArr = 2^0^1
		return xorAll ^ xorArr; // (0^1^2^3) ^ (2^0^1) -> 3
	}

//	===========================================================================================================================
//	drawback if n is too large example n= 10 raise to 7 then int will not work we have to use long
//	but this dosent happens in the xor because it will return int that is either 0 or 1
	private static int findMissingUsingSum(int[] arr) {
		int n = arr.length;
		int sum = (n * (n + 1)) / 2;
		for (int i = 0; i < n; i++) {
			sum -= arr[i];
		}
		return sum;
	}

}
