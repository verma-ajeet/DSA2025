package recursion;

public class PowerLinear {
	public static void main(String[] args) {
		int x = 5;
		int n = 3;
		System.out.println(power(n, x));
		System.out.println(power2(n, x));
	}

	private static int power(int n, int x) {
		if (x == 0) {
			return 1;
		}
		int num = power(n, x - 1);
//		System.out.println(num);
		int f = num * n;
		return f;
	}

	private static int power2(int n, int x) {
		if (x == 0) {
			return 1;
		}
		int num = power(n, x / 2);
		System.out.println(num);
		int xn = num * num;
		if (xn % 2 == 1) {
			xn = xn * n;
		}
		return xn;
	}
}
