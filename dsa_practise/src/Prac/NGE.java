package Prac;

import java.util.Arrays;
import java.util.Stack;

public class NGE {
	public static void main(String[] args) {
		int[] arr = { 15, 10, 16, 20, 8, 9, 7, 50 };
		int n = arr.length;
		neextGreaterElement(arr, n);
	}

	private static void neextGreaterElement(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			while(!s.isEmpty() && arr[i]>arr[s.peek()]) {
				arr[s.pop()]=arr[i];
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			arr[s.pop()]=-1;
		}
		System.out.println(Arrays.toString(arr));
	}
}
