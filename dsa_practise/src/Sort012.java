import java.util.Arrays;

public class Sort012 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 2, 1, 0, 0 };
		System.out.println(Arrays.toString(arr));
		int n = arr.length - 1;
		sortDucthAlgo(arr, n);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortDucthAlgo(int[] arr, int n) {
		int low = 0;
		int mid = 0;
		int high = n;
		while (mid <= high) {
			switch (arr[mid]) {
			case 0:
				swap(arr, low, mid);
				low++;
				mid++;
				break;

			case 1:
				mid++;
				break;

			case 2:
				swap(arr, mid, high);
				high--;
				break;

			}
		}
	}

	private static void swap(int[] arr, int low, int high) {
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
