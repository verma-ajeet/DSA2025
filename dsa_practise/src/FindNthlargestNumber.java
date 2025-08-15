import java.util.Arrays;
import java.util.Comparator;

public class FindNthlargestNumber {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int n = arr.length;
		int target = 3;
		getNthLargestStream(arr, target);
	}

	private static void getNthLargestStream(int[] arr, int target) {
		Arrays.stream(arr).boxed().distinct()
				.sorted(Comparator.comparingInt(Integer::intValue).reversed())
				.skip(target - 1)
				.limit(1).forEach(System.out::println);
	}
}
