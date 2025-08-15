package array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SegregateOddEven {
	public static void main(String[] args) {
		int[] arr= {1,20,5,30,13,10};
		int[] array = Arrays.stream(arr).boxed()
		.collect(Collectors.partitioningBy(v->v%2==0))
		.values().stream()
		.flatMapToInt(list->list.stream().mapToInt(Integer::intValue))
		.toArray();
		System.out.println("using stream "+Arrays.toString(array));
		segregateEvenOdd(arr);
	}

	private static void segregateEvenOdd(int[] arr) {
		int n=arr.length;
		int left=0,right=n-1;
		while(left<right) {
			while(arr[left]%2==1) {
				left++;
			}
			while(arr[right]%2==0) {
				right--;
			}
			if(left<right) {
				int temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
		}
		System.out.println("using two pointers "+Arrays.toString(arr));
	}
}
