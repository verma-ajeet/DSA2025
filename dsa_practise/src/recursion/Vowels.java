package recursion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Vowels {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps right over the little lazy dog";
		List<String> collect = Arrays.stream(str.split(" ")).map(String::toUpperCase).
		filter(
				w->{
					long c=Arrays.stream(w.split("")).filter(ch->"AEIOU".contains(ch)).count();
					return c==2;
				}
			  ).collect(Collectors.toList());
		System.out.println(collect);
		List<String> collect2 = Arrays.stream(str.split(" ")).map(String::toUpperCase).filter(w->{
			long c=Arrays.stream(w.split("")).filter(ch->"AEIOU".contains(ch)).count();
			return c==2;
		}).collect(Collectors.toList());
		System.out.println(collect2);
		Arrays.stream(str.split(" ")).map(String::toUpperCase).filter(w->{
			long c=Arrays.stream(w.split("")).filter(ch->"AEIOU".contains(ch)).count();
			return c==2;
		}).forEach(System.out::println);
		String s="aeiocdesfs";
		s.chars().mapToObj(c->(char)c).map(String::valueOf).map(String::toUpperCase).filter(ch->"AEIOU".contains(ch)).forEach(System.out::println);
	}
}
