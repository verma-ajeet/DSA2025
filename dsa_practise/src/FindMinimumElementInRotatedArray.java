import java.util.Arrays;
import java.util.Comparator;

public class FindMinimumElementInRotatedArray {
	public static void main(String[] args) {
		int[] arr = { 5, 6, 1, 2, 3, 4 };
//		Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(3)
//				.forEach(System.out::println);
		int n = arr.length;
		int element = getElement(arr, 0, n - 1);
		System.out.println(element);
		int[] arr1 = { 1, 2, 3, 4 };
		n = arr1.length;
		element = getElement(arr1, 0, n - 1);
		System.out.println(element);
	}

	private static int getElement(int[] arr, int left, int right) {
		while (left < right) {
			int mid = (left + right) / 2;
			// Check if mid is the minimum element
			if (arr[mid] < arr[mid - 1]) {
				return arr[mid];
			}
			// If the left half is sorted, the minimum
			// element must be in the right half3
			if (arr[mid] > arr[right]) {
				left = mid + 1;
			} else {
				// If the right half is sorted, the minimum
				// element must be in the left half
				right = mid - 1;
			}
		}
		return -1;
	}
}
