package Prac;

import java.util.Arrays;

public class RotateRightArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int n=arr.length-1;
		int key=2;
		System.out.println(Arrays.toString(arr));
		rotateRight(arr,n,key);
		System.out.println(Arrays.toString(arr));
	}
// 12345
// 54321
// 34521
// 34512
	private static void rotateRight(int[] arr, int n, int key) {
		key=key%n;
		reverse(arr,0,n-key);
		reverse(arr,n-key+1,n);
		reverse(arr,0,n);
	}

	private static void reverse(int[] arr, int start, int end) {
		while(start<arr.length/2) {
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;
			end--;
		}
	}
}
