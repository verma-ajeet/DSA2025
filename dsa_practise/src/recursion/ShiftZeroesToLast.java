package recursion;

import java.util.Arrays;

public class ShiftZeroesToLast {
	public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3, 0, 0, 0, 9, 8};
        int sync=0;
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]!=0) {
        		int temp=arr[i];
        		arr[i]=arr[sync];
        		arr[sync]=temp;
        		sync++;
        	}
        }
        System.out.println(Arrays.toString(arr));
	}
}
