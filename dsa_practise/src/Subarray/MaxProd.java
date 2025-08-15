package Subarray;

public class MaxProd {
	public static void main(String[] args) {
		int[] arr = { 2, 3, -2, 4 };
		int n = arr.length;
		getMaxSum(arr, n);
		getMaxProductBrute(arr, n); // n3
		getMaxProductBetter(arr, n); // n2
		getMaxProductOptimal(arr, n); // n
	}

	private static void getMaxProductBetter(int[] arr, int n) {
		int maxProd=0;
		for(int i=0;i<n;i++) {
			int prod=1;
			for(int j=i;j<n;j++) {
				prod*=arr[j];
				maxProd=Math.max(maxProd, prod);
			}
		}
		System.out.println("max prod using better code = "+maxProd);
	}

	private static void getMaxProductBrute(int[] arr, int n) {
		int maxProd=0;
		for(int i=0;i<n;i++) {
			for(int j=i;j<n;j++) {
				int prod=1;
				for(int k=i;k<j;k++) {
					prod*=arr[k];
				}
				maxProd=Math.max(maxProd, prod);
			}
		}
		System.out.println("max prod using brute code = "+maxProd);
	}

	private static void getMaxProductOptimal(int[] arr, int n) {
		int pref=1,suff=1;
		int max=0;
		for(int i=0;i<n;i++) {
			if (pref == 0) {
				pref = 1;
			}
			if (suff == 0) {
				suff = 1;
			}
			pref=pref*arr[i];
			suff=suff*arr[n-i-1];
			max=Math.max(max, Math.max(pref, suff));
		}
		System.out.println("max prod using optimal code = "+max);
	}

	private static void getMaxSum(int[] arr, int n) {
		int sum=0,max=0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			max=Math.max(max, sum);
			if(sum<0) {
				sum=0;
			}
		}
		System.out.println(max);
	}
}
