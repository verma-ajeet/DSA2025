import java.util.Arrays;

public class MoveZero {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 1, 0, 0, 0 };
		int n = arr.length;
		System.out.println(Arrays.toString(arr));
		move(arr, n);
	}

	private static void move(int[] arr, int n) {
		int index=0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				arr[index]=arr[i];
				index++;
			}
		}
		for(int i=index;i<n;i++) {
			arr[i]=0;
		}
		System.out.println(Arrays.toString(arr));
	}
}
