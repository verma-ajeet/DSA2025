package recursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Merge {
	public static void main(String[] args) {
		int[] a = new int[] { 4, 2, 1, 2 };
		int[] b = new int[] { 5, 7, 4, 2 };
//		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().forEach(System.out::println);
//		IntStream concat = IntStream.concat(Arrays.stream(a), Arrays.stream(b));
		IntStream.concat(Arrays.stream(a), Arrays.stream(b)).forEach(System.out::println);
		List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
		 int[] nums = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
		List<Integer> collect = listOfIntegers.stream().sorted().collect(Collectors.toList());
		System.out.println(collect);
		System.out.println("-----------------------");
		listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
		System.out.println("-----------------------");
		listOfIntegers.stream().sorted().limit(3).forEach(System.out::println);
		String s1 = "RaceCar";
		String s2 = "CarRace";
		Arrays.stream(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		s1 = Arrays.stream(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.out.println("s1= " + s1);
		s2 = Arrays.stream(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if (s1.equals(s2)) {
			System.out.println("anagram");
		}
		int i = 1235;
		String[] split = String.valueOf(i).split("");
		Integer collect2 = Arrays.stream(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
		System.out.println(collect2);
		int reduce = Arrays.stream(a).reduce(0, (acc, curr) -> acc + curr);
		System.out.println(reduce);
		int n = 1234;
		Arrays.stream(String.valueOf(n).split("")).collect(Collectors.summingInt(Integer::parseInt));
		Integer integer2 = listOfIntegers.stream().distinct().sorted((f, s) -> Integer.compare(s, f)).skip(1)
				.findFirst().get();
		Integer integer = listOfIntegers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();
		System.out.println(integer + " " + integer2);
		List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
		List<String> collect3 = listOfStrings.stream().sorted(Comparator.comparing(String::length))
				.collect(Collectors.toList());
		System.out.println(collect3);
		listOfStrings.stream().sorted((f,s)->Integer.compare(f.length(), s.length())).forEach(System.out::println);
		Integer collect4 = listOfIntegers.stream().collect(Collectors.summingInt(num->num));
		System.out.println(collect4);
		Arrays.stream(nums).sum();
		
	}
}
