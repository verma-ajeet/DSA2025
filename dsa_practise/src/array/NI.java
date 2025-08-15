package array;

import java.util.Arrays;
import java.util.Stack;

public class NI {
	public static void main(String[] args) {
		int[] arr = { 15, 10, 16, 20, 8, 9, 7, 50 };
		getNI(arr);
		getNextGreater(arr);
	}

	private static void getNI(int[] arr) {
		int[] res=new int[arr.length];
		Arrays.fill(res, -1);
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				if(arr[j]>arr[i]) {
					res[i]=arr[j];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(res));
	}

	private static void getNextGreater(int[] arr) {
		Stack<Integer> s = new Stack<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
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
