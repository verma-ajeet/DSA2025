package StringPrac;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubStringWithoutRepeatingCharacter {
	public static void main(String[] args) {
		String input = "abcabcbb";
		System.out.println("len= " + lengthOfLongestSubstring(input));
		System.out.println(lengthOfLongestSubstringUsingHashSet(input));
	}

	private static int lengthOfLongestSubstring(String input) {
		int max = 0, left = 0;
		int n = input.length();
		HashMap<Character, Integer> m = new HashMap<>();
		for (int right = 0; right < n; right++) {
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
		int max = 0, left = 0;
		HashSet<Character> s = new HashSet<>();
		int n = input.length();
		int right=0;
		while (right<n) {
			char c = input.charAt(right);
			if (!s.contains(c)) {
				s.add(c);
				max = Math.max(max, right - left + 1);
				right++;
			} else {
				s.remove(c);
				left++;
			}
		}
		return max;
	}

}
