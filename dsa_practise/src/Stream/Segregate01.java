package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import LL.qs;

public class Segregate01 {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 1, 1, 0, 0, 0, 0, 1, 0 };
		segregate01UsingStream(arr);
		int[] arr1 = { 0, 1, 1, 0, 0, 0, 1, 0 };
		qsort(arr1, 0, arr1.length-1);
		System.out.println(Arrays.toString(arr1));
		List<Integer> collect = Arrays.stream(arr1).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void qsort(int[] arr, int start, int end) {
		if (start < end) {
			int pindex = partition(arr, start, end);
			qsort(arr, start, pindex - 1);
			qsort(arr, pindex + 1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start - 1;
		for (int j = start; j < arr.length; j++) {
			if(arr[j]<pivot) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[end];
		arr[end]=temp;
		
		return i+1;
	}

	private static void segregate01UsingStream(int[] arr) {
		int[] result = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i == 0)).values().stream()
				.flatMapToInt(list -> list.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(result));
	}
}
