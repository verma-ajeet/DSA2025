import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateFromArrayInPlace {
	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] array = Arrays.stream(nums).distinct().toArray();
		Set<Integer> set=new HashSet<>();
		List<Integer> collect = Arrays.stream(nums).boxed().filter(i->set.add(i)).collect(Collectors.toList());
		System.out.println(collect);
		long count = Arrays.stream(nums).boxed().distinct().count();
		System.out.println(count);
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				nums[i + 1] = nums[j];
				i++;
			}
		}
		System.out.println(Arrays.toString(nums));
		return i+1;

	}
}
