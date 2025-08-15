package recursion;

public class Increasing {
	public static void main(String[] args) {
		int n = 5;
		printIncreasing(5);
	}

	private static void printIncreasing(int n) {
		if(n==0) {
			return;
		}
		printIncreasing(n-1);
		System.out.println(n);
	}
}
