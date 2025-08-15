import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 3, 4, 5 };
		int[] arr2 = { 2, 3, 30, 4, 5, 6 };
		List<Integer> collect = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed()).sorted()
				.collect(Collectors.toList());
		System.out.println(collect);
		int j = arr.length;
		int k = 0;
		for (int i = 0; i < arr.length || j < arr2.length; i++) {
			arr[i] = collect.get(i);
			if (k < arr2.length) {
				arr2[k] = collect.get(j);
				k++;
				j++;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));
	}
}
