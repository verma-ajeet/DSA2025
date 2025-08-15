import java.util.Arrays;

public class LeftRotateByD {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		bruteForceLeftRotate(arr, 2);
		System.out.println(Arrays.toString(arr));
		leftRotate(arr, 2);
		System.out.println("left rotated= " + Arrays.toString(arr));
		rightRotate(arr, 2);
		rightRotate(arr, 2);
		System.out.println("right rotated= " + Arrays.toString(arr));
	}

    public static void bruteForceLeftRotate(int[] arr, int k) {
        int length = arr.length;
        k = k % length; // Handle the case where k is greater than the length

        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            System.out.println("temp" + temp);
            for (int j = 0; j < length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[length - 1] = temp;
        }
        System.out.println(" brute force "+Arrays.toString(arr));
    }

// 1 2 3 4 5 6 7 -> 7 6 5 4 3 2 1 -> 6 7 5 4 3 2 1 -> 6 7 1 2 3 4 5
// 3 4 5 6 7 1 2
//    step 1 -> reverse complete array
//    step 2 -> reverse first part
//    step 3 -> reverse second part
	private static void rightRotate(int[] arr, int rotations) {
		int len = arr.length;
		rotations = rotations % len;
		if (rotations == len) {
			return;
		}
		System.out.println(rotations);
//		reverse complete array
		reverseArray(arr, 0, len - 1);
//		reverse first part
		reverseArray(arr, 0, rotations - 1);
//		reverse second part
		reverseArray(arr, rotations, len - 1);
	}

	// 1 2 3 4 5 6 7 -> 2 1 3 4 5 6 7 -> 2 1 7 6 5 4 3 -> 3 4 5 6 7 1 2
//	The reverseArray function is called three times, each taking linear time in 
//	the size of the reversed subarray. O(n)
	private static void leftRotate(int[] arr, int rotations) {
		int len = arr.length;
		rotations = rotations % len;
		if (rotations == len) {
			return;
		}
		System.out.println(rotations);
//		reverse first part
		reverseArray(arr, 0, rotations - 1);
//		reverse second part
		reverseArray(arr, rotations, len - 1);
		// reverse complete array
		reverseArray(arr, 0, len - 1);
	}

	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
//      System.out.println(Arrays.toString(arr));
	}

}
