import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondSmallest {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		List<Integer> array = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
		System.out.println(array.get(arr.length - 1));
		IntStream stream = Arrays.stream(arr);
		Stream<Integer> boxed = stream.boxed();
		IntSummaryStatistics collect = Arrays.stream(arr).boxed().collect(Collectors.summarizingInt(i -> i));
		System.out.println("max= " + collect.getMax() + " min= " + collect.getMin());
		System.out.println("sorted= " + array);
		secondSmallest(arr);
	}

	private static void secondSmallest(int[] arr) {
		int smallest = Integer.MAX_VALUE;
		int ssmallest = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (smallest > arr[i]) {
				ssmallest = smallest;
				smallest = arr[i];
			} else if (arr[i] != smallest && arr[i] < ssmallest) {
				ssmallest = arr[i];
			}
		}
		System.out.println("smallest= " + smallest + " ssmallest= " + ssmallest);
	}
}
