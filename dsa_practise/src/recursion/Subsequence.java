package recursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Subsequence {
	public static void main(String[] args) {
		String mainString = "Hello, world!";
		IntStream chars = mainString.chars();
		Stream<Character> mapToObj = chars.mapToObj(s -> (char) s);
		String subString = "lood";
		boolean isSubsequence = isSubsequence(mainString, subString);
		if (isSubsequence) {
			System.out.println(subString + " is a subsequence of " + mainString);
		} else {
			System.out.println(subString + " is not a subsequence of " + mainString);
		}
		System.out.println(subsequencerecursion(mainString, subString, 0, 0));
		List<String> unsortedList = Arrays.asList("banana", "apple", "cherry", "date", "elderberry", "fig");
		unsortedList.stream().sorted().forEach(System.out::println);
		unsortedList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		unsortedList.stream().sorted().limit(1).forEach(System.out::println);
	}

	private static boolean isSubsequence(String mainString, String subString) {
		int mainIndex = 0;
		int subIndex = 0;

		while (mainIndex < mainString.length() && subIndex < subString.length()) {
			if (mainString.charAt(mainIndex) == subString.charAt(subIndex)) {
				subIndex++;
			}
			mainIndex++;
		}
		return subIndex == subString.length();
	}

	private static boolean subsequence(String mainstr, String substr) {
		int mainind = 0;
		int subind = 0;
		while (mainind < mainstr.length() && subind < substr.length()) {
			if (mainstr.charAt(mainind) == substr.charAt(subind)) {
				subind++;
			}
			mainind++;
		}
		return subind == substr.length();
	}

	private static boolean subsequencerecursion(String mainstr, String substr, int subind, int mainind) {

		if (subind == substr.length()) {
			return true;
		}
		if (mainind == mainstr.length()) {
			return false;
		}
        if(mainstr.charAt(mainind)==substr.charAt(subind)) {
        	return subsequencerecursion(mainstr, substr,subind+1,mainind+1);
        }else {
        	return subsequencerecursion(mainstr, substr, subind, mainind+1);
        }
	}
}
