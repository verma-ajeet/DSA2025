import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static void main(String[] args) {
		int[] arr = { -2, -1, -2, -1, -2, -1, 2, 0, 2, 0, 2, 0, 2 };
		int n = arr.length;
		threeSumOptimal(arr, n);
	}

	private static void threeSumOptimal(int[] arr, int n) {
		List<List<Integer>> l = new ArrayList<>();
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i+1, k = n - 1;
			while (j < k) {
				int sum = arr[i] + arr[j] + arr[k];
				if (sum == 0) {
					l.add(Arrays.asList(arr[i], arr[j], arr[k]));
					j++;
					k--;
					while (j < k && arr[j] == arr[j - 1]) {
						j++;
					}
					while (j < k && arr[k] == arr[k + 1]) {
						k--;
					}
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		System.out.println(l);
	}
}
