package Prac;

public class SlidingWindowFixed {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println("Max sum of subarray of size " + k + ": " + maxSum(arr, k));
    }

	private static int maxSum(int[] arr, int k) {
		int currSum=0,maxSum=0;
		int n=arr.length;
		for(int i=0;i<k;i++) {
			currSum += arr[i];
		}
		for(int i=k;i<n;i++) {
			currSum += arr[i]-arr[i-k];
			if(currSum>maxSum) {
				maxSum=currSum;
			}
		}
		return maxSum;
	}
}
