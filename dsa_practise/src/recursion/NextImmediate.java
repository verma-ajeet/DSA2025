package recursion;

public class NextImmediate {
	public static void main(String[] args) {
		int arr[] = { 15, 10, 16, 20, 8, 9, 7, 50 };

		for (int i = 0; i < arr.length; i++) {
			int currentNumber = arr[i];
			int nextHigherNumber = Integer.MAX_VALUE;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > currentNumber && arr[j] < nextHigherNumber) {
					nextHigherNumber = arr[j];
				}
			}
			if (nextHigherNumber == Integer.MAX_VALUE) {
				System.out.println("For " + currentNumber + ", next immediate higher number is -1");
			} else {
				System.out.println("For " + currentNumber + ", next immediate higher number is " + nextHigherNumber);
			}
		}
	}
}
