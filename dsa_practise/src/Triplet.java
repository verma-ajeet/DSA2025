import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Triplet {
	public static void main(String[] args) {
		int[] arr = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;
		int len = arr.length;
		findTriplet(arr, sum, len);
		System.out.println(threeSumApproach3(arr));
		int[] nums = { -1, 0, 1, 2, -1, -4 };
		System.out.println("approach 1");
		System.out.println(threeSumApproach1(nums));
		System.out.println("approach 2");
		System.out.println(threeSumApproach2(nums));
		System.out.println("approach 3");
		System.out.println(threeSumApproach3(nums));
		int[] arr1 = { 2, 3, 30, 4, 5, 6, 7, 1 };
		System.out.println(threeSumApproach3(arr1));
		System.out.println(threeSumApproach3(arr));
	}

	private static void findTriplet(int[] arr, int sum, int len) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == sum) {
						System.out.println("[ " + arr[i] + "," + arr[j] + "," + arr[k] + " ]");
					}
				}
			}
		}
	}

	public static List<List<Integer>> threeSumApproach1(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> s = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						s.add(Arrays.asList(nums[i], nums[j], nums[k]));
					}
				}
			}
		}
		return new ArrayList<>(s);
	}

	public static List<List<Integer>> threeSumApproach2(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> result = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			Set<Integer> set = new HashSet<>();
			for (int j = i + 1; j < nums.length; j++) {
				int remaining = -(nums[i] + nums[j]);
				if (set.contains(remaining)) {
					// Found a triplet
					List<Integer> triplet = Arrays.asList(nums[i], nums[j], remaining).stream().sorted()
							.collect(Collectors.toList());
					;
					result.add(triplet);
				}
				set.add(nums[j]);
			}
		}

		// No need to convert to List if you are fine with Set<List<Integer>> as the
		// result
		return new ArrayList<>(result);
	}

	public static List<List<Integer>> threeSumApproach3(int[] nums) {
		List<List<Integer>> result=new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++) {
			if(i>0&&nums[i]==nums[i-1]) {
				continue;
			}
			int j=i+1;
			int k=nums.length-1;
			while(j<k) {
				int sum=nums[i]+nums[j]+nums[k];
				if(sum<0) {
					j++;
				}
				else if (sum>0) {
					k--;
				}
				else {
                   result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                   j++;
                   k--;
                   while(j<k && nums[j]==nums[j+1]) {
                	   j++;
                   }
                   while(j<k && nums[k]==nums[k+1]) {
                	   k--;
                   }
				}
			}
		}
		return result;
	}
}
