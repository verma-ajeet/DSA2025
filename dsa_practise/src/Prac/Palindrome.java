package Prac;

public class Palindrome {
	public static void main(String[] args) {
		String num = "121";
		System.out.println(chackPalindrome(num));
		Integer num1 = 100;
		Integer num2 = 100;
		Integer num3 = 500;
		Integer num4 = 500;

		System.out.println(num1.equals(num2));
		System.out.println(num1.hashCode() + " " + num2.hashCode());
		System.out.println(num1 == num2);
		System.out.println(num3.equals(num4));
		System.out.println(num3.hashCode() + " " + num4.hashCode());
		System.out.println(num3 == num4);
	}

	private static boolean chackPalindrome(String n) {
		Integer num = Integer.valueOf(n);
		System.out.println(num);
		int right = n.length() - 1;
		for (int left = 0; left < n.length(); left++) {
			if (n.charAt(left) != n.charAt(right)) {
				return false;
			}
			right--;
		}
		return true;
	}
}
