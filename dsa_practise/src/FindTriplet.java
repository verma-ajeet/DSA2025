import java.util.Arrays;

public class FindTriplet {
	public static void main(String[] args) {
		int[] A = { 1, 4, 45, 6, 10, 8 };
		int sum = 20;
		int arr_size = A.length;

		// Call the find3Numbers function to find and print
		// the triplet, if it exists
		if (!find3Numbers(A, arr_size, sum)) {
			System.out.println("No triplet found with the given sum.");
		}else {
			System.out.println("yes triplet");
		}
	}

	private static boolean find3Numbers(int[] arr, int arr_size, int sum) {
		Arrays.sort(arr);
		for(int i=0;i<arr_size;i++) {
			if(i>0&&arr[i]==arr[i-1]) {
				continue;
			}
			int j=i+1;
			int k=arr_size-1;
			while(j<k) {
				int totalsum=arr[i]+arr[j]+arr[k];
				if(totalsum<sum) {
					j++;
				}else if(totalsum>sum){
					k--;
				}else {
					System.out.println(arr[i]+" "+arr[j]+" "+arr[k]);
					return true;
				}
			}
		}
		return false;
	}
}
