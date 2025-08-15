import java.util.Arrays;

public class QuickS {
	public static void main(String[] args) {
		int[] arr = { 4, 7, 3, 9, 0, 10, 1 };
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		quickSort(arr, 0, n - 1);
		System.out.println(Arrays.toString(arr));
	}

// TC 
	private static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int partionIndex=partition(arr,low,high);
			quickSort(arr, low, partionIndex-1);
			quickSort(arr, partionIndex+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot=arr[high];
		int i=low-1;
		for(int j=low;j<high;j++) {
			if(pivot>=arr[j]) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}
}
