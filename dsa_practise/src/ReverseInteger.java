import java.util.Arrays;

public class ReverseInteger {
	public static void main(String[] args) {
		int num = 123;
		System.out.println("Reversed: " + reverse(num));

		int num2 = -123;
		System.out.println("Reversed: " + reverse(num2));

		int num3 = 120;
		System.out.println("Reversed: " + reverse(num3));

		int num4 = 1534236469; // Overflow test case
		System.out.println("Reversed: " + reverse(num4));
	}

	private static int reverse(int n) {
		int reversed = 0;
		while (n != 0) {
			int digit = n % 10;
			n /= 10;
			if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
				return 0;
			}
			reversed = reversed * 10 + digit;
		}
		return reversed;
	}
}
