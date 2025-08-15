package Tree;

import java.util.HashMap;
import java.util.Map;

public class Ana {
	public static void main(String[] args) {
		String s = "bab";
		String s1 = "aba";
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (m.containsKey(s.charAt(i))) {
				m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
			} else {
				m.put(s.charAt(i), 1);
			}
		}
		System.out.println(m);
		for (int i = 0; i < s.length(); i++) {
			char c = s1.charAt(i);
			if (m.containsKey(c)) {
				m.put(c, m.get(c) - 1);
			}
		}
		int minSteps = 0;
		for (int count : m.values()) {
			if(count>0) {
				minSteps += count;
			}
		}
		System.out.println(minSteps);
	}
}
