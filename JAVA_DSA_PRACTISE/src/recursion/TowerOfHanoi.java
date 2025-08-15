package recursion;

public class TowerOfHanoi {
	public static void main(String[] args) {
		int n = 3;
		towerOfHanoi(n, "S", "H", "D");
	}

	private static void towerOfHanoi(int n, String source, String helper, String dest) {
		if (n == 1) {
			System.out.println("transfer disk " + n + " from " + source + " to " + dest);
			return;
		}
		towerOfHanoi(n - 1, source, dest, helper);
		System.out.println("transfer disk " + n + " from " + source + " to " + dest);
        towerOfHanoi(n-1, helper, source, dest);
	}
}
