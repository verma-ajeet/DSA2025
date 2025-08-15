import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 5 };
		int[] arr2 = { 2, 3, 3, 4, 5, 6 };
		List<Integer> union = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed()).distinct()
				.collect(Collectors.toList());
		Arrays.stream(arr).boxed().distinct().filter(i -> Arrays.stream(arr2).boxed().anyMatch(y -> y == i))
				.forEach(System.out::println);
		getIntersection(arr, arr2);
		getIntersectionOptimal(arr, arr2);
	}

	private static void getIntersectionOptimal(int[] arr, int[] arr2) {
		Arrays.sort(arr);
		Arrays.sort(arr2);
		int n = arr.length;
		int m = arr.length;
		int i = 0, j = 0;
		List<Integer> l=new ArrayList<>();
		while (i < n && j < m) {
			if (arr[i] < arr2[j]) {
				i++;
			} else if (arr[i] > arr2[j]) {
				j++;
			} else {
				l.add(arr[i]);
				i++;
				j++;
			}
		}
		System.out.println("optimal result "+l);
	}

	private static void getIntersection(int[] arr, int[] arr2) {
		List<Integer> l = new ArrayList<>();
		for (int num1 : arr) {
			for (int num2 : arr2) {
				if (num1 == num2) {
					l.add(num1);
					break; // Break to avoid adding duplicates
				}
			}
		}
		System.out.println("intersection = " + l);
	}
}
