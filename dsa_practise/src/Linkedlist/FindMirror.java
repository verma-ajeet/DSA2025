package Linkedlist;

public class FindMirror {
	public static void main(String[] args) {
		int[] arr = { 4, 2, 3, 1, 2 };
		printMirror(arr);
	}

	private static void printMirror(int[] arr) {
		if (arr.length == 0) {
			System.out.println("array is empty");
			return;
		}
		for(int i=1;i<=arr.length;i++) {
			System.out.println(arr[arr.length-i]);
		}
	}
}
