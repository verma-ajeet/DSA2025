import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumByHashing {
	public static void main(String[] args) {
		int[] arr = { 4, 7, 3, 9, 0, 10, 1 };
		int n = arr.length;
		int k = 10;
		System.out.println(Arrays.toString(getTwoSum(arr, n, k)));
	}

	private static int[] getTwoSum(int[] arr, int n, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int remaining = k - arr[i];
			if (!m.containsKey(remaining)) {
				m.put(arr[i], i);
			} else {
				System.out.println("index " + i + " " + m.get(remaining));
				return new int[] { arr[i], arr[m.get(remaining)] };
			}
		}

		return new int[] { 0, 0 };
	}
}
