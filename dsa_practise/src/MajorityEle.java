import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityEle {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 3, 1, 2, 2 };
		int n = arr.length;
		int majority = getMajority(arr, n);
		System.out.println(majority);
		getMajorityMoore(arr, n);
		Entry<Integer, Long> entry = Arrays.stream(arr).boxed()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);
	}

	private static void getMajorityMoore(int[] arr, int n) {
		int data = arr[0];
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (count == 0) {
				data = arr[i];
			}
			if (data == arr[i]) {
				count++;
			} else {
				count--;
			}
		}
		count = 0;
		for (int value : arr) {
			if (value == data) {
				count++;
			}
		}
		if (count > arr.length / 2) {
			System.out.println("moores "+data);
		}
	}

	private static int getMajority(int[] arr, int n) {
		Arrays.sort(arr);
		int mid = n / 2;
		System.out.println(arr[mid]);
		if (arr[0] == mid || mid == arr[n - 1]) {
			return arr[mid];
		} else {
			return -1;
		}
	}

}
