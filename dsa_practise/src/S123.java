import java.util.Arrays;

public class S123 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 2, 1, 0, 1, 0, 0, 2, 0 };
		int n = arr.length;
		sort(arr, n);
		System.out.println(Arrays.toString(arr));
	}
// dutch national flag algorithm
//	l-m-1 m-h-1 h-n-1 n
	private static void sort(int[] arr, int n) {
		int low = 0;
		int mid = 0;
		int high = n-1;
		while(mid<=high) {
			switch(arr[mid]) {
			case 0:
				swap(arr,low,mid);
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

	private static void swap(int[] arr, int low, int mid) {
		int temp=arr[low];
		arr[low]=arr[mid];
		arr[mid]=temp;
	}
}
