package StringPrac;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		String input = "abcabcbb";
		System.out.println("len= " + lengthOfLongestSubstring(input));
		System.out.println(lengthOfLongestSubstringUsingHashSet(input));
	}

	private static int lengthOfLongestSubstring(String input) {
		int max = 0, left = 0;
		HashMap<Character, Integer> m = new HashMap<>();

		for (int right = 0; right < input.length(); right++) {
			char c = input.charAt(right);
			if (m.containsKey(c)) {
				left = Math.max(m.get(c) + 1, left);
			}
			max = Math.max(max, right - left + 1);
			m.put(c, right);
		}
		return max;
	}

	private static int lengthOfLongestSubstringUsingHashSet(String input) {
		HashSet<Character> s = new HashSet<>();
		int start = 0, end = 0;
		int n = input.length();
		int maxlength = 0;
		while (end < n) {
			char c = input.charAt(end);
			if (!s.contains(c)) {
				s.add(c);
				maxlength = Math.max(maxlength, end - start + 1);
				end++;
			} else {
				s.remove(c);
				start++;
			}
		}
		return maxlength;
	}

//	private static int lengthOfLongestSubstring(String input) {
//		int n = input.length();
//		int maxlength = 0;
//		HashMap<Character, Integer> m = new HashMap<>();
//		int left = 0;
//		for (int right = 0; right < n; right++) {
//			char c = input.charAt(right);
//			if (m.containsKey(c)) {
//				left = Math.max(m.get(c) + 1, left);
//			}
//			maxlength = Math.max(maxlength, right - left + 1);
//			m.put(c, right);
//		}
//		return maxlength;
//	}
}
