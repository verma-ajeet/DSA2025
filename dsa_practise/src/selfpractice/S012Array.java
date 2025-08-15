package selfpractice;

import java.util.Arrays;

public class S012Array {
	public static void main(String[] args) {
		int[] arr= {0,1,0,2,0,0,1,1};
		int n=arr.length-1;
		sort012(arr,n);
	}

	private static void sort012(int[] arr, int n) {
		int low=0;
		int high=n,mid=0;
		while(mid<=high) {
			if(arr[mid]==0) {
				swap(arr,low,mid);
				low++;
				mid++;
			}else if(arr[mid]==1) {
				mid++;
			}else if(arr[mid]==2) {
				swap(arr, mid, high);
				high--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void swap(int[] arr, int low, int mid) {
		int temp=arr[low];
		arr[low]=arr[mid];
		arr[mid]=temp;
	}
}
