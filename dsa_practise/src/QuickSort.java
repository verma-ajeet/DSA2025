import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = { 12, 4, 5, 6, 7, 3, 1, 15 };
		int n = arr.length;
		System.out.println("Original array: " + Arrays.toString(arr));
		quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: " + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			System.out.println(partitionIndex);
			quickSort(arr, low, partitionIndex - 1);
			quickSort(arr, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		System.out.println("======================================");
		System.out.println(Arrays.toString(arr));
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
