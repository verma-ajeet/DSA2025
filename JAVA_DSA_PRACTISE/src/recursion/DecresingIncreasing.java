package recursion;

public class DecresingIncreasing {
	public static void main(String[] args) {
      int n=5;
		printDecrasingIncreasing(n);
	}

	private static void printDecrasingIncreasing(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		printDecrasingIncreasing(n-1);
		System.out.println(n);
	}
}
