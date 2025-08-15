package recursion;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PalindromStream {
	public static void main(String[] args) {
		String str = "ROTATOR";
		boolean allMatch = IntStream.range(0, str.length() / 2)
				.allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
		System.out.println(allMatch);
		
		
//		------------------------------------------------------------------------------------------------------
		boolean allMatch2 = IntStream.range(0, str.length() / 2)
				.allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
		String str1 = "abc@gmail.com";
		char[] charArray = str1.toCharArray();
		int startInd = 0;
		int endInd = str1.length() - 1;
		while (startInd < endInd) {
			if (!Character.isLetter(charArray[startInd])) {
				startInd++;
			} else if (!Character.isLetter(charArray[endInd])) {
				endInd--;
			} else {
				char temp = charArray[startInd];
				charArray[startInd] = charArray[endInd];
				charArray[endInd] = temp;
				startInd++;
				endInd--;
			}
		}
		System.out.println(new String(charArray));
		IntStream.range(0, charArray.length).mapToObj(i->charArray[i]);
		String str2 = "RTOATOR";
		String collect = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
	}
}
