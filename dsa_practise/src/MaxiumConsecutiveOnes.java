

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxiumConsecutiveOnes {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 1, 1, 1, 0, 1, 1 };
		int count = getCountMaximumConsecutiveOnesBrute(arr);
		System.out.println(count);
		int[] array = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i->i==0))
				.values().stream()
				.flatMapToInt(list->list.stream().mapToInt(Integer::intValue))
				.toArray();
		System.out.println(Arrays.toString(array));
		int[] array2 = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i->i==2)).values().stream().flatMapToInt(list->list.stream().mapToInt(Integer::intValue)).toArray();
		Map<Boolean, List<Integer>> collect = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i->i==0));
		System.out.println(collect);
		int[] array3 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.partitioningBy(i->i%2==0)).values().stream().flatMapToInt(list->list.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(array3));
	}

	private static int getCountMaximumConsecutiveOnesBrute(int[] arr) {
		int result=0;
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				temp++;
			}
			else {
				temp=0;
			}
			result=Math.max(result, temp);
		}
		return result;
	}
}
