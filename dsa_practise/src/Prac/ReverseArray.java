package Prac;

import java.util.Arrays;

public class ReverseArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(Arrays.toString(arr));
		reverse(arr);
		int[] arr1 = { 1, 2, 3, 4};
		System.out.println(Arrays.toString(arr1));
		reverse(arr1);
	}

	private static void reverse(int[] arr) {
		int j=arr.length-1;
		for(int i=0;i<arr.length/2;i++) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			j--;
		}
		System.out.println(Arrays.toString(arr));
	}
}
