package Prac;

import java.util.Arrays;

public class QS {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 2, 10, 8, 6, 2, 0 };
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		qs(arr,0,n-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void qs(int[] arr, int start, int end) {
		if(start<end) {
			int pindex=partition(arr,start,end);
			qs(arr,start,pindex-1);
			qs(arr, pindex+1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot=arr[end];
		int i=start-1;
		for(int j=start;j<end;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[end];
		arr[end]=temp;
		return i+1;
	}
}
