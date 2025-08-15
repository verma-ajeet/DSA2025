import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeS {
	public static void main(String[] args) {
		int[] arr = { -2, -1, -2, -1, -2, -1, 2, 0, 2, 0, 2, 0, 2 };
		int n = arr.length;
		getSum(arr, n, 0);
		int[] arr1= {0,1,1,1,0,1,0,0,1};
		int[] array = Arrays.stream(arr1).boxed().collect(Collectors.partitioningBy(i->i==0))
		.values().stream().flatMapToInt(l->l.stream().mapToInt(Integer::intValue)).toArray();
		System.out.println(Arrays.toString(array));
	}

	private static void getSum(int[] arr, int n, int key) {
		int sum = 0;
		Arrays.sort(arr);
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i > 0 && arr[i] == arr[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = n - 1;
			while (j < k) {
				sum = arr[i] + arr[j] + arr[k];
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
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}
		System.out.println(l);
	}
}
