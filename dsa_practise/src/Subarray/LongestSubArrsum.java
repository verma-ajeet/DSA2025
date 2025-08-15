package Subarray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrsum {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int n = arr.length;
		int k = 15;
		lenOfLongSubarrBrute(arr, n, k);
	}

	private static void lenOfLongSubarrBrute(int[] arr, int n, int k) {
		int sum=0;
		Map<Integer,Integer> m =new HashMap<>();
		int max=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			if (sum == k) {
				max = i + 1;
			}
			else if(m.containsKey(sum-k)) {
				max=Math.max(max,m.get(sum-k));
			}
			m.put(sum, i);
		}
		System.out.println(max);
	}
}
