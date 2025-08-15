package selfpractice;

public class MaxSumSubArray {
	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = arr.length;
		getSum(arr, n);
	}

	private static void getSum(int[] arr, int n) {
		int sum=0;
		int max=0;
		int tempstart=0,start=0,end=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			if(sum<0) {
				sum=0;
				tempstart=i+1;
			}else {
				max=Math.max(sum, max);
				start=tempstart;
				if(max>sum) {
					end=i;
				}
			}
		}
		for(int i=start;i<end;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println(max);
	}
}
