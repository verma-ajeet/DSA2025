package selfpractice;

public class MajorityE {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 3, 2, 4, 5, 2, 6, 2 };
		int n = arr.length;
		getMajority(arr, n);
	}

	private static void getMajority(int[] arr, int n) {
		int count = 0, num = 0;
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				num = arr[i];
				count++;
			} else {
				if (arr[i] == num) {
					count++;
				} else {
					count--;
				}
			}
		}
		if (count > 0) {
			count = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == num) {
					count++;
				}
			}
		}
		if (count >= n / 2) {
			System.out.println("element "+num+ " is repeated "+count+" times");
		}

	}
}
