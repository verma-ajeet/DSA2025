import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheNumberThatAppearsOnce {
	public static void main(String[] args) {
		int[] arr = { 1, 1,5, 4, 2, 3, 3, 4, 4 };
		int num = getNumberApperingOnce(arr);
		System.out.println("brute result "+num);
		int num1 = getNumberApperingOnceXor(arr);
		System.out.println("xor result "+num1);
		Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(map->map.getValue()==1).forEach(System.out::println);
	}

	private static int getNumberApperingOnceXor(int[] arr) {
		  return Arrays.stream(arr)
	                .reduce((a, b) -> a ^ b)
	                .orElse(0);
	}

	private static int getNumberApperingOnce(int[] arr) {
		List<Integer> l =new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int temp = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					temp++;
					if (temp == 2) {
						break;
					}
				}
			}
			if (temp == 1) {
				l.add(arr[i]);
			}
		}
		System.out.println(l);
		return -1;
	}
}
