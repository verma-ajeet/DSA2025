package BinarySearch;

public class SearchElementInArray {
	public static void main(String[] args) {
		int[] arr = { -1, 0, 3, 5, 9, 12 };
		int target = 9;

		int result = search(arr, target);
		if (result == -1) {
			System.out.println("not present");
		} else {
			System.out.println("target is present");
		}
		result = searchRecursive(arr, target, 0, arr.length - 1);
		System.out.println("abc");
		System.out.println(result);
	}

	private static int searchRecursive(int[] arr, int target, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (arr[mid] == target) {
			return arr[mid];
		}
		if (target > arr[mid]) {
			return searchRecursive(arr, target, mid + 1, right);
		} else {
			return searchRecursive(arr, target, left, mid - 1);
		}
	}

	private static int search(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] == target) {
				return arr[mid];
			}
			if (target > arr[mid]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
