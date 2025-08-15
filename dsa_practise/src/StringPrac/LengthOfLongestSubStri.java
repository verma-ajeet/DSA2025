package StringPrac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubStri {
	public static void main(String[] args) {
		String input = "abcabcbb";
		System.out.println("len= " + lengthOfLongestSubstring(input));
		System.out.println(lengthOfLongestSubstringUsingHashMap(input));
	}

	private static int lengthOfLongestSubstringUsingHashMap(String input) {
		int left = 0, sum = 0,max=0;
		Map<Character, Integer> m = new HashMap<>();
		int n = input.length();
		for (int right = 0; right < n; right++) {
			char c=input.charAt(right);
			if(m.containsKey(c)) {
				left=Math.max(m.get(c)+1, left);
			}
			m.put(c, right);
			max=Math.max(max, right-left+1);
		}
		return max;
	}

	private static int lengthOfLongestSubstring(String input) {
		Set<Character> s=new HashSet<>();
		int end=0,start=0,n=input.length();
		int max=0;
		while(end<n) {
			char c=input.charAt(end);
			if(s.contains(c)) {
				s.remove(c);
				start++;
			}else {
				s.add(c);
				max=Math.max(max, end-start+1);
				end++;
			}
		}
		return max;
	}
}
