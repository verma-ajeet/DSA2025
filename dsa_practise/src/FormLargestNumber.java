import java.util.Arrays;

public class FormLargestNumber {
	public static void main(String[] args) {
		int[] nums = { 3, 30, 34, 5, 9 };
		String result = largestNumberOptimal(nums);
		System.out.println("Largest Number (Optimal): " + result);
	}

	private static String largestNumberOptimal(int[] nums) {
		String result = "";
		String[] str = Arrays.stream(nums).mapToObj(Integer::toString).toArray(String[]::new);
		Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
		System.out.println(Arrays.toString(str));
		for (String data : str) {
			result = result + "" + data;
		}
		System.out.println(result);
		return null;
	}
}
