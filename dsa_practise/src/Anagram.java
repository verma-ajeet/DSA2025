import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		String word1 = "listen";
		String word2 = "silent";
		checkAnagramXor(word1.toLowerCase(),word2.toLowerCase());
		checkAnagram(word1.toLowerCase(),word2.toLowerCase());
	}

	private static void checkAnagram(String w1, String w2) {
		char[] c1 = w1.toCharArray();
		char[] c2 = w2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		System.out.println(Arrays.equals(c1, c2));
		
	}

	private static void checkAnagramXor(String word1, String word2) {
		int xorResult=0;
		for(int i=0;i<word1.length();i++) {
			xorResult^=word1.charAt(i);
			xorResult^=word2.charAt(i);
		}
		if(xorResult==0) {
			System.out.println("anagram");
		}else {
			System.out.println("not anagram");
		}
	}
}
