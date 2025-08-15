import java.util.Arrays;
import java.util.Comparator;

public class ThreeLargestNumbers {
	public static void main(String[] args) {
		int[] arr = { 15, 10, 16, 20, 8, 9, 7, 50 };
		Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(3)
				.forEach(System.out::println);
		System.out.println(Arrays.toString(arr));
		int n = arr.length;
		getThreeLargest(arr, 0, n-1);
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[n-1]+" "+arr[n-2]+" "+arr[n-3]);
	}

	private static void getThreeLargest(int[] arr, int start, int end) {
		if (start < end) {
			int partitionIndex = partition(arr, start, end);
			getThreeLargest(arr, start, partitionIndex - 1);
			getThreeLargest(arr, partitionIndex+1, end);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				// Swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("======================================");
		// Swap arr[i+1] and arr[high] (put the pivot element in its correct position)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;

	}

}
