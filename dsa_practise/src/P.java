import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P {
	public static void main(String[] args) {
		String s = "I am interested123455 to grow in my organization";
		Optional<String> max = Arrays.stream(s.split(" ")).map(String::toUpperCase).filter(w -> w.matches("[A-Z0-9]+"))
				.max(Comparator.comparingInt(String::length));
		String str = "dabfcadef";
		String collect2 = Arrays.stream(str.split("")).collect(Collectors.toSet()).stream()
				.collect(Collectors.joining());
		System.out.println("remove duplicates " + collect2);
		System.out.println(max.get());
		int a[] = { 5, 7, 5, 7, 5, 2 };
		Entry<Integer, Long> entry = Arrays.stream(a).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println(entry);
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(arr));
		rotateRight(arr, arr.length, 2);
		System.out.println(Arrays.toString(arr));
		rotateLeft(arr, arr.length, 2);
		System.out.println(Arrays.toString(arr));
		int[] arr1 = { 1, 2, 3, 4, 5 };
		rotate(arr, arr1.length, 2);
		int[] a1 = { 1, 1, 2, 3, 3, 4, 5 };
		int[] a2 = { 2, 3, 30, 4, 5, 6 };
		List<Integer> collect = Stream.concat(Arrays.stream(a1).boxed(), Arrays.stream(a2).boxed()).sorted()
				.collect(Collectors.toList());
		Arrays.stream(a2).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(3)
				.forEach(System.out::println);
		System.out.println(a2.length);
		quickSort(a2, 0, a2.length - 1);
		System.out.println(Arrays.toString(a2));
		int[] array = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0)).values().stream()
				.flatMapToInt(l -> l.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(array));
		int[] a3 = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
		int[] array2 = Arrays.stream(a3).boxed().collect(Collectors.partitioningBy(i -> i == 0)).values().stream()
				.flatMapToInt(l -> l.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(array2));
		movezero(a3, a3.length);
		int aray1[] = { 1, 2, 3, 4, 5 };
		int aray2[] = { 5, 4, 3, 2, 1};
		Arrays.stream(aray2).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).limit(3).forEach(System.out::println);
		checkEqual(aray1, aray2);
		IntSummaryStatistics collect3 = IntStream.range(0, 10).boxed().collect(Collectors.summarizingInt(i->i));
		int[] arrr= {5,6,4,0,0,0,5,58,2,2,0};
		Arrays.stream(arrr).boxed().collect(Collectors.partitioningBy(i->i==0))
		.values().stream().flatMapToInt(l->l.stream().mapToInt(Integer::intValue)).toArray();
	}
 
	private static void checkEqual(int[] aray1, int[] aray2) {
		int value = 0;
		int value2 = 0;
		if (aray1.length == aray2.length) {
			for (int i = 0; i < aray1.length; i++) {
				value ^= aray1[i];
				value2 ^= aray2[i];
			}
			System.out.println("xor " + (value == value2));
		}

	}

	private static void movezero(int[] arr, int n) {
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[index] = arr[i];
				index++;
			}
		}
		while (index < n) {
			arr[index] = 0;
			index++;
		}
		System.out.println("zero " + Arrays.toString(arr));
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pindex = partition(arr, start, end);
			quickSort(arr, 0, pindex - 1);
			quickSort(arr, pindex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			if (arr[j] < pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;

		return i + 1;
	}

	private static void rotate(int[] arr, int n, int k) {
		for (int i = 0; i < k; i++) {
			int temp = arr[0];
			for (int j = 0; j < n - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[n - 1] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

	private static void rotateRight(int[] arr, int n, int k) {
		k = k % n;
		if (n == k || k == 0) {
			return;
		}
		reverse(arr, 0, n - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);
	}

	private static void rotateLeft(int[] arr, int n, int k) {
		k = k % n;
		if (n == k || k == 0) {
			return;
		}
		reverse(arr, 0, k - 1);
		reverse(arr, k, n - 1);
		reverse(arr, 0, n - 1);
	}

	private static void reverse(int[] arr, int left, int right) {
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

}
