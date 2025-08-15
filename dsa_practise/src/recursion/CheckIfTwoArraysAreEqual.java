package recursion;

public class CheckIfTwoArraysAreEqual {
	public static void main(String[] args) {
		int arr1[] = { 21, 6, 8, 9, 10, 5 };
		int arr2[] = { 10, 21, 5, 8, 6, 9 };
		System.out.println(checkArrays(arr1, arr2));
	}

	private static boolean checkArrays(int[] arr1, int[] arr2) {
		if (arr1.length != arr2.length) {
			return false;
		}
		int len = 0;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					len++;
				}
			}
		}
		if (len == arr1.length) {
			return true;
		} else {
			return false;
		}
	}
}
