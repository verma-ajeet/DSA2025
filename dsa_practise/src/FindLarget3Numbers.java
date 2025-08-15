import java.util.Arrays;
import java.util.Comparator;

public class FindLarget3Numbers {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 30, 4, 5, 6 };
		getLargestThreeElementsUsingStream(arr);
		getLargestThreeElementsUsingBruteWay(arr);
		System.out.println(Arrays.toString(getLargestThreeElementsUsingOptimalWay(arr)));
	}

	private static void getLargestThreeElementsUsingBruteWay(int[] nums) {
		if (nums.length < 3) {
			return;
		}

		Arrays.sort(nums);
		int[] largestThree = new int[3];
		int length = nums.length;

		// Select the last three elements after sorting
		largestThree[0] = nums[length - 1];
		largestThree[1] = nums[length - 2];
		largestThree[2] = nums[length - 3];
		System.out.println(Arrays.toString(largestThree));

	}

	private static int[] getLargestThreeElementsUsingOptimalWay(int[] nums) {
	    if (nums.length < 3) {
            return nums;
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > firstLargest) {
                thirdLargest = secondLargest;
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest) {
                thirdLargest = num;
            }
        }
        return new int[]{firstLargest, secondLargest, thirdLargest};
	}

	private static void getLargestThreeElementsUsingStream(int[] arr) {
		Arrays.stream(arr).boxed().distinct().sorted(Comparator.reverseOrder()).limit(3).forEach(System.out::println);
	}
}
