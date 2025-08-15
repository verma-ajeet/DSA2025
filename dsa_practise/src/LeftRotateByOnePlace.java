import java.util.Arrays;

public class LeftRotateByOnePlace {
	public static void main(String[] args) {
     int[] arr= {1,2,3,4,5};
     rotateleft(arr);
	}
//   1,2,3,4,5 -> 5,1,2,3,4
	private static void rotateleft(int[] arr) {
		int n=arr.length;
		int temp=arr[0];
		 for(int i=1;i<arr.length;i++) {
			arr[i-1]=arr[i];
		 }
		 arr[n-1]=temp;
		 System.out.println(Arrays.toString(arr));
	}
}
