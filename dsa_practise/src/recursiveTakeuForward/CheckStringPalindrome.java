package recursiveTakeuForward;

public class CheckStringPalindrome {
	public static void main(String[] args) {
		String str = "racecar";
		System.out.println(checkIfPalindrome(str, 0));
		str = "Hello World";
		System.out.println(checkIfPalindrome(str, 0));
		str = "A man a plan a canal Panama";
		System.out.println(checkIfPalindrome(str.replaceAll(" ", "").toLowerCase(), 0));
	}

	private static boolean checkIfPalindrome(String str, int start) {
		if (start >= str.length() / 2) {
			return true;
		}
		if (str.charAt(start) != str.charAt(str.length() - 1 - start)) {
			return false;
		}
		return checkIfPalindrome(str, start + 1);
	}
}
// 7 6 5 4 3 2 1 0  