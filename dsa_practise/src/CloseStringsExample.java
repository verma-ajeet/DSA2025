import java.util.Arrays;

public class CloseStringsExample {
	public static void main(String[] args) {
		String word1 = "abc";
		String word2 = "bca";
		System.out.println("Example 1: " + closeStrings(word1, word2));

		word1 = "a";
		word2 = "aa";
		System.out.println("Example 2: " + closeStrings(word1, word2));

		word1 = "cabbba";
		word2 = "abbccc";
		System.out.println("Example 3: " + closeStrings(word1, word2));
	}

	public static boolean closeStrings(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}

		int[] count1 = new int[26];
		int[] count2 = new int[26];

		for (char c : word1.toCharArray()) {
			count1[c - 'a']++;
		}

		for (char c : word2.toCharArray()) {
			count2[c - 'a']++;
		}

		Arrays.sort(count1);
		Arrays.sort(count2);
		return Arrays.equals(count1, count2) && Arrays.equals(word1.chars().distinct().sorted().toArray(),
				word2.chars().distinct().sorted().toArray());
	}
}
