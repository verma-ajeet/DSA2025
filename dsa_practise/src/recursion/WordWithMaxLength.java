package recursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WordWithMaxLength {
	public static void main(String[] args) {
		String s = "I am interested123455 to grow in my organization";
		String string = Arrays.stream(s.split(" ")).max(Comparator.comparingInt(String::length)).get();
		String string2 = Arrays.stream(s.split(" ")).min(Comparator.comparingInt(String::length)).get();
		System.out.println(string + " = " + string.length());
		System.out.println(string2);
		Arrays.stream(s.split(" ")).filter(w -> w.length() == 2).forEach(System.out::println);
		String str = "The quick brown fox jumps right over the little lazy dog";
		List<String> collect = Arrays.stream(str.split(" ")).map(String::toUpperCase).filter(w -> {
			long co = Arrays.stream(w.split("")).filter(ch -> "AEIOU".contains(ch)).count();
			return co == 2;
		}).collect(Collectors.toList());
		System.out.println(collect);
		String str1="dabfcadef";
		String collect2 = Arrays.stream(str1.split("")).distinct().collect(Collectors.joining(""));
		System.out.println(collect2);
		String str2="abc@gmail.com";
		
	}
}
