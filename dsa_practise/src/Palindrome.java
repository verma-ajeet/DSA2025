
public class Palindrome {
	public static void main(String[] args) {
		String str = "Racecar";
		checkPalindrome(str.toLowerCase());
		String str1 = "rar";
		checkPalindrome(str1.toLowerCase());
		str = "raq";
		checkPalindrome(str.toLowerCase());
		str = "rara";
		checkPalindrome(str.toLowerCase());
	}

	private static void checkPalindrome(String str) {
		int n = str.length() - 1;
		int c=n/2;
		int count=0;
		for (int i = 0; i < str.length() / 2; i++) {
//			System.out.println(str.charAt(i)+" "+str.charAt(n-i));
			if (str.charAt(i) == str.charAt(n - i)) {
				count++;
			}
		}
		System.out.println(count == c);
	}
}

