package selfpractice;

import java.util.HashMap;

public class LongestSubArrayEqualToK {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int n = arr.length;
		int k = 15;
		longestSub(arr, n, k);
	}

	private static void longestSub(int[] arr, int n, int k) {
		HashMap<Integer, Integer> m = new HashMap<>();
		int sum = 0, max = 0, start = 0, end = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == k) {
				max = i + 1;
			} else if (m.containsKey(sum - k)) {
				max = Math.max(max, i - m.get(sum - k));
				start = m.get(sum - k) + 1;
				end = i;
			}
			if (!m.containsKey(sum)) {
				m.put(sum, i);
			}
		}
		for(int i=start;i<=end;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("= "+sum+" and total count is "+max);
	}
}
