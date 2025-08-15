
public class NumberPalindrome {
	public static void main(String[] args) {
		int n = 121;
		String str = Integer.toString(n);
		boolean checkPalindrome = checkPalindrome(str);
		System.out.println(checkPalindrome);
	}

	private static boolean checkPalindrome(String str) {
		int left = 0, right = str.length();
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
		}
		return true;
	}
}
