package selfpractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int arr1[] = { 1, 3, 4, 5 };
		int arr2[] = { 2, 4, 6, 8 };
		List<Integer> merged = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed()).sorted()
				.collect(Collectors.toList());
		System.out.println(merged);
		int[] mergedArray = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed()).sorted()
				.mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(mergedArray));
	}
}
