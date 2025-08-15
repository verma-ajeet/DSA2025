import java.util.Arrays;
import java.util.OptionalInt;

public class PrintLargest {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		OptionalInt max = Arrays.stream(arr).max();
		System.out.println(max.getAsInt());
		printLargest(arr);
	}

	private static void printLargest(int[] arr) {
		int curr=Integer.MIN_VALUE;
		for(int arr_value:arr) {
			if(curr<arr_value) {
				curr=arr_value;
			}
		}
		System.out.println(curr);
	}
}
