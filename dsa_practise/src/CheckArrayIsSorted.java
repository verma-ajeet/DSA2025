import java.util.Arrays;

public class CheckArrayIsSorted {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 3, 3, 4 };
		System.out.println("array "+Arrays.toString(arr)+" is sorted = "+  checkSorted(arr));
	}

	private static boolean checkSorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] >= arr[i - 1]) {
			} else {
				return false;
			}
		}
		return true;
	}
}
