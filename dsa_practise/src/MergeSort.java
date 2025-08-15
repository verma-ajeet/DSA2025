import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 15, 10, 16, 20, 8, 9, 7, 50 };
		int n = arr.length;
		mergeSort(arr, 0, n);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
//			By using (right - left) / 2, you ensure that the division is performed
//			before adding to left, preventing integer overflow issues that might 
//			occur if you simply used (left + right) / 2.
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {
		int n1 = mid - left + 1;
		int n2 = right - mid;
		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];
		for(int i=0;i<n1;i++) {
			leftArray[i]=arr[left+i];
		}
		for(int i=0;i<n2;i++) {
			rightArray[i]=arr[mid+1+i];
		}
		int i=0,j=0,k=left;
		while(i<n1&&j<n2) {
			if(leftArray[i]<=rightArray[j]) {
				arr[k]=leftArray[i];
				i++;
			}else {
				arr[k]=rightArray[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k]=leftArray[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k]=leftArray[j];
			j++;
			k++;
		}
	}
}
