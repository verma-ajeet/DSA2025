package array;

import java.awt.image.RescaleOp;
import java.util.Arrays;

public class Threesumcloses {
	public static void main(String[] args) {
		int[] arr = { -1, 2, 1, -4 };
		int target = 1;
		getClosestSum(arr, target);
	}
//	Find a triplet in an array whose sum is closest to a given number
	private static void getClosestSum(int[] arr, int target) {
		int n=arr.length;
		Arrays.sort(arr);
		int min=Integer.MAX_VALUE;
		int result=0;
		for(int i=0;i<n;i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int left=i+1;
			int right=n-1;
			while(left<right) {
				int sum=arr[i]+arr[left]+arr[right];
				if(sum<target) {
					left++;
				}else {
					right--;
				}
				int diff=Math.abs(sum-target);
				if(diff<min) {
					result=sum;
					min=diff;
				}
			}
			
		}
		System.out.println(result);
	}
}
