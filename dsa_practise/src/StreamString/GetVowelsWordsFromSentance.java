package StreamString;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetVowelsWordsFromSentance {
	public static void main(String[] args) {
		String str1 = "The quick brown fox jumps right over the little lazy dog";
		Arrays.stream(str1.split(" "))
		.map(String::toUpperCase)
		.filter(w->{
			long count = Arrays.stream(w.split(""))
				.filter(c->"AEIOU".contains(c))
				.count();
			return count==2;
		}).forEach(System.out::println);
	}
	public void useBoxed() {
		 int[] numbers = {1, 2, 3, 9, 5, 4, 8};
		 IntStream stream = Arrays.stream(numbers);
		 stream.boxed().collect(Collectors.toList());
	}
//	public static long getVowelWords(String word) {
//		long count=0;
//		for(char c:word.toCharArray()) {
//			if("aeiou".indexOf(c)>=0) {
//				count++;
//			}
//		}
//	}
}
