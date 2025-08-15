package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice {
	public static void main(String[] args) {
		String s = "I am interested123455 to grow in my organization";
		String strr = Arrays.stream(s.split(" ")).map(String::toLowerCase).max(Comparator.comparingInt(String::length))
				.get();
		System.out.println("strr "+strr);

		String ls = Arrays.stream(s.split(" ")).map(String::toLowerCase).filter(w -> w.matches("[a-z]+"))
				.max(Comparator.comparingInt(String::length)).get();
		System.out.println("ls " + ls);
		String longestString = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).get();
		System.out.println(longestString);
		String str = "dabfcadef";
		List<String> collect = Arrays.stream(str.split("")).distinct().collect(Collectors.toList());
		System.out.println(collect.stream().collect(Collectors.joining()));
		int arr[] = { 5, 7, 5, 7, 5, 2 };
		Entry<Integer, Long> entry = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);
		long count = Arrays.stream(arr).boxed().filter(v -> v == 5).count();
		System.out.println(count);
		int arr1[] = { 21, 6, 8, 9, 10, 5 };
		int arr2[] = { 10, 21, 5, 8, 6, 9 };
		boolean checkBalance = checkBalance(arr1, arr2);
		System.out.println(checkBalance);
		Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
				.stream().max(Map.Entry.comparingByValue()).get();
		String str1 = "The quick brown fox jumps right over the little lazy dog";
		
		List<String> collect4 = Arrays.stream(str1.split(" "))
			.map(String::toLowerCase)
			.filter(w->{
				long len=Arrays.stream(w.split(""))
					.filter(c->"aeiou".contains(c))
					.count();
				return len==2;
			}).collect(Collectors.toList());
		System.out.println("collect 4 "+collect4);
		
		
		
		
		
		
		
		
		
		
		
		List<String> collect3 = Arrays.stream(str1.split(" ")).map(String::toLowerCase).filter(w -> {
			long cou = Arrays.stream(w.split("")).filter(c -> "aeiou".contains(c)).count();
			return cou == 2;
		}).collect(Collectors.toList());
		System.out.println(collect3);
		int[] a = { 0, 1, 1, 1, 0, 0, 0, 0, 1, 0 };
		int[] array = Arrays.stream(a).boxed().collect(Collectors.partitioningBy(i -> i == 0)).values().stream()
				.flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println("zeroes shifted " + Arrays.toString(array));

//		List<String> collect2 = Arrays.stream(str.split(" ")).map(String::toUpperCase).filter(w->{
//			long c=Arrays.stream(w.split("")).filter(ch->"AEIOU".contains(ch)).count();
//			return c==2;
//		}).collect(Collectors.toList());
		List<String> collect2 = Arrays.stream(str1.split(" ")).map(String::toLowerCase).filter(w -> {
			long l = Arrays.stream(w.split("")).filter(c -> "aeiou".contains(c)).count();
			return l == 2;
		}).collect(Collectors.toList());
		System.out.println(collect2);
		int[] arr3 = { 15, 10, 16, 20, 8, 9, 7, 50 };
		int n = arr3.length;
		neextGreaterElement(arr3, n);
		int[] arr4 = { 15, 10, 16, 20, 8, 9, 7, 50 };
		nextGreaterElementBrute(arr4, arr4.length);
	}

	private static void nextGreaterElementBrute(int[] nums, int n) {
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			result[i] = -1; // Initialize with -1, as there may not be a greater element
			for (int j = i + 1; j < n; j++) {
				if (nums[j] > nums[i]) {
					result[i] = nums[j];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(result));
	}

	private static void neextGreaterElement(int[] arr, int n) {
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				arr[s.pop()] = arr[i];
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			arr[s.pop()] = -1;
		}
		System.out.println("Next greater element " + Arrays.toString(arr));
	}

	private static boolean checkBalance(int[] arr1, int[] arr2) {
		int xor = 0;
		if (arr1.length != arr2.length) {
			return false;
		} else {
			for (int i = 0; i < arr1.length; i++) {
				xor ^= arr1[i];
				xor ^= arr2[i];
			}
			if (xor == 0) {
				return true;
			}
		}
		return false;
	}
}
