import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p1 {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 30, 4, 5, 6, 7, 1 };
		Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(1).limit(1)
				.forEach(System.out::println);
		Object[] array = Arrays.stream(arr).boxed().sorted().toArray();
		System.out.println(Arrays.toString(array));
		int n = arr.length;
		getSecondLargest(arr, n);
		getTriplet(arr, 0, n, 11);
	}

	private static void getTriplet(int[] arr, int start, int end, int key) {
		Arrays.sort(arr);
		if (end == 0) {
			return;
		}

		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < end; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = end - 1;
			while (j < k) {
				int sum = (arr[j] + arr[k] + arr[i]);
				if (sum == key) {
					l.add(Arrays.asList(arr[i], arr[j], arr[k]));
					j++;
					k--;
					while (j < k && arr[j] == arr[j + 1]) {
						j++;
					}
					while (j < k && arr[k] == arr[k + 1]) {
						k--;
					}
				} else if (sum < key) {
					j++;
				} else {
					k--;
				}
			}
		}
		System.out.println("triplets " + l);
	}

	private static void getSecondLargest(int[] arr, int n) {
		int largest = Integer.MIN_VALUE;
		int slargest = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (arr[i] > largest) {
				slargest = largest;
				largest = arr[i];
			} else if (arr[i] < largest && arr[i] > slargest) {
				slargest = arr[i];
			}
		}
		System.out.println(largest + " " + slargest);
	}
}
