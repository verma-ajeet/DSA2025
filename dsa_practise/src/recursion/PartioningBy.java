package recursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PartioningBy {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(20, 12, 4, 3, 2, 1, 5, 7, 8, 23, 54);
		Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
		Set<Entry<Boolean, List<Integer>>> entrySet = collect.entrySet();
//		for (Entry<Boolean, List<Integer>> set : entrySet) {
//			System.out.println("-------------------------------");
//			if (set.getKey()) {
//				System.out.println("even numbers");
//			}else {
//				System.out.println("odd numbers");
//			}
//			System.out.println("-------------------------------");
//			List<Integer> value = set.getValue();
//			for(Integer num:value) {
//				System.out.println(num);
//			}
//		}
		String inputString = "Java Concept Of The Day";
		Map<String, Long> collect2 = Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));	
		System.out.println(collect2);
		List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> collect3 = stationeryList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(collect3);
        List<Double> decilist=Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        decilist.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        List<String> listOfStrings = Arrays.asList("Facebooke", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        String collect4 = listOfStrings.stream().collect(Collectors.joining(",","[","]"));
        System.out.println(collect4);
        Optional<Double> max = decilist.stream().max(Comparator.naturalOrder());
        Optional<Double> min = decilist.stream().min(Comparator.naturalOrder());
        List<String> collect5 = listOfStrings.stream().sorted(Comparator.comparingInt(String::length).reversed()).limit(1).collect(Collectors.toList());
        System.out.println(collect5);
//        listOfStrings.stream().mapToInt(String::length).m
	}
}
