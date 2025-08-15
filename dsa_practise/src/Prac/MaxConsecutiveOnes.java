package Prac;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxConsecutiveOnes {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };
		int n=arr.length;
		getNoOfConsecutiveOnes(arr,n);
		getNoOfConsecutiveOnesUsingStream(arr);
	}

	private static void getNoOfConsecutiveOnesUsingStream(int[] arr) {
		int[] array = Arrays.stream(arr).boxed()
		.collect(Collectors.partitioningBy(i->i==1))
		.values()
		.stream()
		.flatMapToInt(list->list.stream().mapToInt(Integer::intValue))
		.toArray();
		System.out.println(Arrays.toString(array));
	}

	private static void getNoOfConsecutiveOnes(int[] arr, int n) {
		int count=0;
		int curr=arr[0];
		int max=0;
		for(int i=1;i<n;i++) {
			if(arr[i]!=1) {
				curr=arr[i];
				count=0;
			}else {
				count++;
			}
			max=Math.max(max, count);
		}
		System.out.println(max);
	}
}
