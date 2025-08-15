package recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReverseEachWordOfArray {
	public static void main(String[] args) {
		String str = "this is a book";
        String collect = Arrays.stream(str.split(" ")).map(w->new StringBuffer(w).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect);
        System.out.println("------------------------------------------------------------------");
		List<String> listOfString = Arrays.asList("pen", "pencil", "book");
		listOfString.stream().map(w -> new StringBuffer(w).reverse()).forEach(System.out::println);
		String s="abc";
		String collect2 = Stream.of(s)
        .map(word->new StringBuilder(word).reverse())
        .collect(Collectors.joining(" "));
		System.out.println(collect2);
		Stream<String> of = Stream.of(s);
	}
}
