import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		String input = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(input));
		System.out.println(lengthOfLongestSubstringUsingSet(input));
	}

	private static int lengthOfLongestSubstring(String input) {
		HashMap<Character, Integer> charIndexMap = new HashMap<>();
		int maxLength = 0;
		int n = input.length();
		int left = 0;
		for (int right = 0; right < n; right++) {
			char currentChar = input.charAt(right);
			if (charIndexMap.containsKey(currentChar)) {
				left = Math.max(charIndexMap.get(currentChar) + 1, left);
			}
			maxLength = Math.max(maxLength, right - left + 1);
			charIndexMap.put(currentChar, right);
		}
		return maxLength;
	}

	public static int lengthOfLongestSubstringUsingSet(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashSet<Character> charSet = new HashSet<>();
		int maxLength = 0;
		int start = 0;
		int end = 0;

		while (end < s.length()) {
			char currentChar = s.charAt(end);

			if (!charSet.contains(currentChar)) {
				charSet.add(currentChar);
				maxLength = Math.max(maxLength, end - start + 1);
				end++;
			} else {
				charSet.remove(s.charAt(start));
				start++;
			}
		}
		return maxLength;
	}
}
