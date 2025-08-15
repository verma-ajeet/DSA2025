package recursion;

public class Factorial {
	public static void main(String[] args) {
		int n = 5;
		int f=fact(n);
		System.out.println(f);
	}

	private static int fact(int n) {
		if(n==1) {
			return 1;
		}
		int f=fact(n-1);
		int fn=n*f;
		return fn;
	}
}
