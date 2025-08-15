package recursion;

public class SecondMaxElement {
	public static void main(String[] args) {
		int[] array = { 5, 8, 2, 10, 7, 1, 15, 3 };
		findTwoMaxElements(array);
	}

	private static void findTwoMaxElements(int[] array) {
		if (array.length < 2) {
			System.out.println("Minimum length of an array must be greater or equal to 2");
			return;
		}
		int max1 = Integer.MIN_VALUE; // initialized to the smallest possible integer
		int max2 = Integer.MIN_VALUE; // initialized to the smallest possible integer
		for (int value : array) {// It compares each element (num) with the current maximum (max1 and max2) and
									// updates them accordingly.
									// The conditions ensure that the same number is not considered as both the
									// first and second maximum.
			if (value > max1) {
				max2 = max1;
				max1 = value;
			} else if (value > max2 && value != max1) {
				max2 = value;
			}
		}
		System.out.println("max2 " + max2);
	}
}
