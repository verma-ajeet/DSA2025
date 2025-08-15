import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PairSum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		List<int[]> pairSum = pairSum(arr, 5);
		pairSum.stream().forEach(pair -> System.out.println("[" + pair[0] + " , " + pair[1] + "]"));
	}

	public static List<int[]> pairSum(int[] arr, int s) {
		List<int[]> l = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				if (sum == s) {
					System.out.println(arr[i] + " " + arr[j]);
					int[] ans = { arr[i], arr[j] };
					l.add(ans);
				}
			}
		}
		return l;
	}
}
