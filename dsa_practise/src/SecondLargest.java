
public class SecondLargest {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		secondLargest(arr);
	}

	private static void secondLargest(int[] arr) {
		int largest = arr[0];
		int slargest = -1;
		for (int data : arr) {
			if (data > largest) {
				slargest = largest;
				largest = data;
			} else if (largest>data && data>slargest) {
				slargest=data;
			}
		}
		System.out.println("largest = "+largest+" slargest = "+slargest);
	}
}
