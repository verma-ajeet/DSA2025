package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamArrayQuestions {
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4 };
		int[] arr2 = { 4, 5, 6, 7 };
		List<Integer> collect = Arrays.stream(arr1).boxed()
				.filter(num1 -> Arrays.stream(arr2).boxed().anyMatch(num2 -> num2 == num1))
				.collect(Collectors.toList());
		System.out.println(collect);
		Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(m -> m.getValue() == 2).forEach(System.out::println);
		List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot", "grapes");
		String fruitWithLargestLength = fruits.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println(fruitWithLargestLength);
		String s="apple banana avocado apricot grapes";
		String string = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).get();
		System.out.println(string);
		int[] arr= {2,4,6,8};
		int[] array = Arrays.stream(arr)
        .map(i -> Arrays.stream(arr).filter(j -> j != i).reduce(1, (x, y) -> x * y))
        .toArray();
		System.out.println(Arrays.toString(array));
		IntStream.range(0, 10).filter(i->i%2==0).forEach(System.out::println);
	}
}
