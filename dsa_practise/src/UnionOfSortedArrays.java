import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// insertion in array take 0(logn)
public class UnionOfSortedArrays {
	static Set<Integer> s = new HashSet<>();

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 3, 4, 5 };
		int[] arr2 = { 2, 3, 4, 5, 6 };
		List<Integer> collect2 = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed()).distinct()
				.collect(Collectors.toList());
		IntStream stream = Arrays.stream(arr);
		Stream<Integer> boxed = Arrays.stream(arr).boxed();
		List<Integer> collect = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed()).distinct()
				.collect(Collectors.toList());
		System.out.println("using stream = " + collect);
		unionArray(arr, arr2);
		System.out.println("optimal");
		unionArrayOptimalSolution(arr, arr2);
	}

	private static void unionArrayOptimalSolution(int[] arr, int[] arr2) {
		int m = arr.length;
		int n = arr2.length;
		int i = 0, j = 0;
		List<Integer> l = new ArrayList<>();
		int[] array = Stream.concat(Arrays.stream(arr).boxed(), Arrays.stream(arr2).boxed())
			  .distinct()
			  .collect(Collectors.partitioningBy(sep->sep==0))
			  .values()
			  .stream()
			  .flatMapToInt(list->list.stream().mapToInt(Integer::intValue))
			  .toArray();
		System.out.println("stream Optimal "+Arrays.toString(array));
		while (i < m && j < n) {
			if (arr[i] < arr[j]) {
				l.add(arr[i]);
				i++;
			} else if (arr[i] > arr[j]) {
				l.add(arr[j]);
				j++;
			}else {
				l.add(arr[i]);
				i++;
				j++;
			}
		}
        while (i < m) {
            l.add(arr[i]);
            i++;
        }

        while (j < n) {
            l.add(arr2[j]);
            j++;
        }
		System.out.println("optimal " + l);
	}

	private static void unionArray(int[] arr, int[] arr2) {
		insert(arr);
		insert(arr2);
		System.out.println("union " + s);
	}

	private static void insert(int[] arr) {
		// TODO Auto-generated method stub
		for (int data : arr) {
			s.add(data);
		}
//		Set<Integer> ss = new HashSet<>();
//		ss.add(20);
//		ss.add(1);
//		ss.add(0);
//		ss.add(9);
//		System.out.println(ss);
	}
}
