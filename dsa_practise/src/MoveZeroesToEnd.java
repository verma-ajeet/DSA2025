import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MoveZeroesToEnd {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
		int[] arr2 = { 0, 2, 0, 3, 8, 0, 5, 0 };
		Arrays.stream(arr2).boxed().collect(Collectors
				.partitioningBy(i->i==0)).values().stream().flatMapToInt(l->l.stream().mapToInt(Integer::intValue))
		   		.toArray();
		int[] array = Arrays.stream(arr2).boxed()
				.sorted((a, b) -> Integer.compare(a == 0 ? Integer.MAX_VALUE : a, b == 0 ? Integer.MAX_VALUE : b))
				.mapToInt(Integer::intValue).toArray();
		int[] array2 = Arrays.stream(arr2).boxed().collect(Collectors.partitioningBy(i -> i == 0)).values().stream()
				.flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println("stream = "+Arrays.toString(array2));
		System.out.println("sorted stream = "+Arrays.toString(array));
		moveZeroes(arr);
	}

	private static void moveZeroes(int[] arr) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[index++] = arr[i];
			}
		}
		for (int i = index; i < arr.length; i++) {
			arr[i] = 0;
		}
		System.out.println(Arrays.toString(arr));
	}
}
