package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExamples {
	public static void main(String[] args) {
//		given list of integers find out all even numbers
		List<Integer> l = Arrays.asList(10, 20, 15, 8, 7, 30);
		List<Integer> evenNumbers = l.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumbers);
//		given a list of integers find out all numbes starting with 1
		int[] arr = { 20, 8, 15, 6, 49, 10, 12 };
		List<String> startsWith1 = Arrays.stream(arr).boxed()
//		.map(String::valueOf)
				.map(d -> d + "").filter(v -> v.startsWith("1")).collect(Collectors.toList());
		System.out.println(startsWith1);
//		find duplicates
		List<Integer> findduplicate = Arrays.asList(10, 15, 5, 10, 98, 5, 98, 32, 15);
		List<Entry<Integer, Long>> getDuplicate = findduplicate.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(m -> m.getValue() == 2).collect(Collectors.toList());
		System.out.println(getDuplicate);
		List<Integer> getDuplicateKey = findduplicate.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(m -> m.getValue() == 2).map(m -> m.getKey()).collect(Collectors.toList());
		System.out.println(getDuplicateKey);
//		count total number of elements
		long totalElement = findduplicate.stream().count();
		System.out.println(findduplicate + " Total Element " + totalElement);
		Integer maxElement = findduplicate.stream().max(Comparator.comparingInt(Integer::intValue)).orElse(0);
		System.out.println(findduplicate + " Max Element" + maxElement);
		int[] arr1 = { -1, 20, 10, -5, -6 };
		int[] segregateNegPos = Arrays.stream(arr1).boxed().collect(Collectors.partitioningBy(v -> v > 0)).values()
				.stream().flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(segregateNegPos));
		segregateNegPos(arr1);
		List<List<Integer>> listOfList= new ArrayList<>();
		listOfList.add(Arrays.asList(5,7,11,13));
		listOfList.add(Arrays.asList(1,3,5));
		listOfList.add(Arrays.asList(5,7,11,13));
		int sum = listOfList.stream().flatMap(list->list.stream()).mapToInt(Integer::intValue).sum();
	}

	private static void segregateNegPos(int[] arr) {
		int n = arr.length - 1;
		int left = 0, right = n;
		while (left < right) {
			while (arr[left] < 0) {
				left++;
			}
			while (arr[right] > 0) {
				right--;
			}
			if(left<right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				right--;
				left++;
			}
		}
		System.out.println("using two pointer "+Arrays.toString(arr));
	}
}
























