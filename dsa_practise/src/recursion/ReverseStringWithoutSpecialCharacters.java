package recursion;

import java.util.Arrays;

public class ReverseStringWithoutSpecialCharacters {
	public static void main(String[] args) {
		String input = "Hello, World!";
		reverse(input);
	}

	private static void reverse(String input) {
		char[] charArray = input.toCharArray();
		int startIndex = 0;
		int endIndex = input.length() - 1;
		while (startIndex < endIndex) {
			if (!Character.isLetter(charArray[startIndex])) {
				startIndex++;
			} else if (!Character.isLetter(charArray[endIndex])) {
				endIndex--;
			} else {
				char temp = charArray[startIndex];
				charArray[startIndex] = charArray[endIndex];
				charArray[endIndex] = temp;
				endIndex--;
				startIndex++;
			}
		}
		System.out.println(Arrays.toString(charArray));
		System.out.println(new String(charArray));
	}
}
