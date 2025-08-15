import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeToSort {
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8, 10 };

		int[] mergedArray = mergeArrays(arr1, arr2);
		System.out.println(Arrays.toString(mergedArray));
		List<Integer> collect = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
				.sorted().collect(Collectors.toList());
		System.out.println("stream "+collect);
	}

	private static int[] mergeArrays(int[] arr1, int[] arr2) {
		int n1 = arr1.length;
		int n2 = arr2.length;
		int[] mergedArray = new int[n1 + n2];
		int i = 0, j = 0, k = 0;
		while (i < n1 && j < n2) {
			if (arr1[i] <= arr2[j]) {
				mergedArray[k++] = arr1[i++];
			} else {
				mergedArray[k++] = arr2[j++];
			}
		}
		while (i < n1) {
			mergedArray[k++] = arr1[i++];
		}
		while (j < n2) {
			mergedArray[k++] = arr2[j++];
		}
		return mergedArray;
	}
}
