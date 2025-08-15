package Prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> grouped = groupAnagrams(input);

		// Print result
		for (List<String> group : grouped) {
			System.out.println(group);
		}
	}

	private static List<List<String>> groupAnagrams(String[] input) {
		if (input == null || input.length == 0)
			return new ArrayList<>();
		Map<String, List<String>> m = new HashMap<>();

		for (String word : input) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);
			if (!m.containsKey(sorted)) {
				m.put(sorted, new ArrayList<>());
			}
			m.get(sorted).add(word);
		}
		m.entrySet().stream().forEach(ma -> {
			System.out.println(ma.getValue());
		});
		return new ArrayList<>(m.values());
	}

}
