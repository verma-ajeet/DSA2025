package recursion;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrintStringReverse {
	public static void main(String[] args) {
		String str = "abcd";
		String collect = Stream.of(str).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
		System.out.println(collect);
		String string = Arrays.asList(str).stream().map(s -> new StringBuilder(str).reverse().toString())
				.collect(Collectors.toList()).get(0);
		System.out.println(string);
		
	}
}
