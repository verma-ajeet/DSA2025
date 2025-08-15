package StreamString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringStream {
	public static void main(String[] args) {
//		Filter and Collect Characters from a String:
		String input = "abc123";
//		Arrays.stream(input.split("")).map(c->Character.isLetter(c.charAt(0))).collect(Collectors.toList());
		input.chars().mapToObj(c->(char)c).filter(Character::isLetter).collect(Collectors.toList());
		List<Character> collect = input.chars().mapToObj(c -> (char) c).filter(Character::isLetter)
				.collect(Collectors.toList());
		System.out.println(collect);
		String collect2 = collect.stream().map(String::valueOf).collect(Collectors.joining());
		System.out.println(collect2);
//		Count Uppercase Letters in a String:
		String text1 = "Hello World";
		long count = text1.chars().mapToObj(c->(char)c).filter(Character::isUpperCase).count();
		System.out.println(count);
//		Convert String to Char Array:
		Character[] array = text1.chars().mapToObj(c->(char)c).toArray(Character[]::new);
		System.out.println(Arrays.toString(array));
		String s = "I am interested123455 to grow in my organization";
		String len = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).get();
		System.out.println(len);
		String lenOnlywords = Arrays.stream(s.split(" ")).map(String::toLowerCase).filter(w->w.matches("[a-z]+")).max(Comparator.comparingInt(String::length)).get();
		System.out.println(lenOnlywords);
		int arr[] = {5,7,5,7,5,2};
		Entry<Integer, Long> max = Arrays.stream(arr).boxed()
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet()
		.stream()
		.max(Map.Entry.comparingByValue()).get();
		System.out.println(max);
		List<String> stringList = Arrays.asList("apple", "banana", "orange"); 
		String collect3 = stringList.stream().map(String::toUpperCase).collect(Collectors.joining(",","[","]"));
		System.out.println(collect3);
		List<String> countString = Arrays.asList("apple", "banana", "orange", "apricot"); 
		long countStr = countString.stream().filter(w->w.startsWith("ap")).count();
		System.out.println("count is "+countStr);
		String longlen = countString.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println(longlen);
		String text = "Hello World"; 
		long countUpper = Arrays.stream(text.split("")).filter(c->Character.isUpperCase(c.charAt(0))).count();
		System.out.println(countUpper);
		long countUpper2 = text.chars().mapToObj(c->(char)c).filter(Character::isUpperCase).count();
		System.out.println(countUpper2);
		String numericString = "12345"; 
		long numcount = Arrays.stream(numericString.split("")).filter(c->Character.isDigit(c.charAt(0))).count();
		System.out.println(numcount==numericString.length());
		String mixedString = "abc123xyz456"; 
		String onlyDigit = Arrays.stream(mixedString.split("")).filter(c->Character.isDigit(c.charAt(0))).collect(Collectors.joining());
		System.out.println(onlyDigit);
		Arrays.stream(mixedString.split("")).filter(c->Character.isDigit(c.charAt(0))).collect(Collectors.joining());
		String original = "Java"; 
		reverse(original);
	}

	private static void reverse(String original) {
		int n=original.length();
		char[] charArray = original.toCharArray();
		for(int i=0;i<n/2;i++) {
			char c=charArray[i];
			charArray[i]=charArray[n-i-1];
			charArray[n-i-1]=c;
		}
		System.out.println(new String(charArray));
	}
}



















