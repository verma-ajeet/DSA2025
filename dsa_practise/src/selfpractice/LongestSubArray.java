package selfpractice;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubArray {
	public static void main(String[] args) {
		int[] arr = { 10, 5, 2, 7, 1, 9 };
		int n = arr.length;
		int k = 15;
		getLongestSubArray(arr, n, k);
	}

	private static void getLongestSubArray(int[] arr, int n, int target) {
	    if (arr == null || arr.length == 0) {
            return ;
        }
		HashMap<Integer, Integer> m = new HashMap<>();
		int max=0,sum=0;
		for (int i = 0; i < n; i++) {
			sum+=arr[i];
			if(sum==target) {
				max=i+1;
			}else if(m.containsKey(sum-target)) {
				max = Math.max(max, i - m.get(sum - target));
			}
			if(!m.containsKey(sum)) {
				m.put(sum, i);
			}
		}
		System.out.println(max);
	}
}
