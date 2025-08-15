import java.util.Arrays;

public class SortAnArray012 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int n = arr.length;
		sortArray(arr, n);
		System.out.println("==========================================");
		sortArrayHashing(arr, n);
		System.out.println(Arrays.toString(arr));
		System.out.println("==========================================");
		qsort(arr, 0, n - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println("==========================================");
		int[] arr2 = { 0, 1, 2, 0, 1, 2, 0, 0, 0, 1};
		int n1 = arr2.length;
		sortArrayOptimal(arr2, n1);
		System.out.println("==========================================");
	}
// dutch national flag problem
	private static void sortArrayOptimal(int[] arr2, int n1) {
		int low = 0;
		int high = n1 - 1;
		int mid = 0;
		while (mid <= high) {
			switch (arr2[mid]) {
			case 0:
				swap(arr2, low, mid);
				mid++;
				low++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr2, mid, high);
				high--;
				break;
			}
		}
		System.out.println(Arrays.toString(arr2));
	}

	private static void swap(int[] arr2, int low, int mid) {
		int temp = arr2[low];
		arr2[low] = arr2[mid];
		arr2[mid] = temp;
	}

	private static void qsort(int[] arr, int low, int high) {
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			qsort(arr, low, partitionIndex - 1);
			qsort(arr, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (pivot >= arr[j]) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	private static void sortArray(int[] arr, int n) {
		int count0 = 0, count1 = 0, count2 = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				count0++;
			} else if (arr[i] == 1) {
				count1++;
			} else {
				count2++;
			}
		}
		int j = 0;
		while (count0 > 0) {
			arr[j] = 0;
			j++;
			count0--;
		}
		while (count1 > 0) {
			arr[j] = 1;
			j++;
			count1--;
		}
		while (count2 > 0) {
			arr[j] = 2;
			j++;
			count2--;
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArrayHashing(int[] arr, int n) {
		int[] array = Arrays.stream(arr).boxed().sorted().mapToInt(Integer::intValue).toArray();
	}

}
