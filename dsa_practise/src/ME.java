
public class ME {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 3, 1, 2, 2 };
		int n = arr.length;
		getME(arr, n);
	}

	private static void getME(int[] arr, int n) {
		int count = 0;
		int start = 0;
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				start = arr[i];
				count++;
			} else {
				if (start == arr[i]) {
					count++;
				} else {
					count--;
				}
			}
		}
		if(count>=n/2) {
			count=0;
			for(int i=0;i<n;i++) {
				if(start==arr[i]) {
					count++;
				}
			}
		}
	}
}
