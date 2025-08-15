package Stream;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SegregateEvenOdd {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 6, 7, 1, 11, 4 };
		int[] segregated = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 1)).values()
				.stream().flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(segregated));
	}
}
