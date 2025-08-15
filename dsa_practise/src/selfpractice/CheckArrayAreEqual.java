package selfpractice;

public class CheckArrayAreEqual {
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 4, 5 };
		int arr2[] = { 1, 2, 4, 3, 5 };
		checkArraysAreEqual(arr1,arr2);
	}

	private static void checkArraysAreEqual(int[] arr1, int[] arr2) {
		int xor=0;
		if(arr1.length!=arr2.length) {
			System.out.println("arrays are not equal");
			return;
		}
		else {
			int n=arr1.length;
			for(int i=0;i<n;i++) {
				xor^=arr1[i];
				xor^=arr2[i];
			}
			if(xor==0) {
				System.out.println("arrays are equal");
			}
		}
	}
}
