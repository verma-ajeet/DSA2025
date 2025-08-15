package recursion;

public class PrintIncreasing {
	public static void main(String[] args) {
		int n = 5;
		printIncreasing(n);
	}

	private static void printIncreasing(int n) {
		if (n == 0) {
			return;
		}
//		System.out.println(n);
		printIncreasing(n - 1);
		System.out.println(n);
	}
}
