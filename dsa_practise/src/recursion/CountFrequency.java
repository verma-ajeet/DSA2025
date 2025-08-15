package recursion;

import java.util.HashMap;
import java.util.Map;

public class CountFrequency {
	public static void main(String[] args) {
		String s1 = "liseen";
		String s2 = "silent";
		countFrequency(s1, s2);
	}

	private static void countFrequency(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return;
		}
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		System.out.println(map);
		for(char c:s2.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c)-1);
				System.out.println(map);
				if (map.get(c)==0) {
					map.remove(c);
				}
			}else {
				System.out.println("not anagram");;
			}
		}
		if(map.isEmpty()) {
			System.out.println("anagram");
		}
	}
}
