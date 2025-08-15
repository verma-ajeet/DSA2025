import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//if elements appears more than n/2 then that element is majority element.
public class MajorityElements {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 2, 3, 1, 2, 2 };
		int n = arr.length - 1;
		getMajorityElementsUsingStream(arr, n);
		System.out.println("2: "+getMajorityElementsBrute(arr, n));
		System.out.println("3: "+getMajorityElementsBetter(arr, n));
		System.out.println("3: "+getMajorityElementsOptimalMooreVotingAlgorithm(arr, n));
	}

	private static int getMajorityElementsOptimalMooreVotingAlgorithm(int[] arr, int n) {
		int result=0,count=0;
		for(int i=0;i<=n;i++) {
			if(count==0) {
				result=arr[i];
				count++;
			}else {
				if(result==arr[i]) {
					count++;
				}else {
					count--;
				}
			}
		}
		count=0;
		for(int i=0;i<n;i++) {
			if(result==arr[i]) {
				count++;
			}
		}
		if(count>n/2) {
			return result;
		}
		return -1;
	}

	private static int getMajorityElementsBetter(int[] arr, int n) {
		Map<Integer,Integer> m =new HashMap<>();
		for(int i=0;i<n;i++) {
			m.put(arr[i],m.getOrDefault(arr[i], 0)+1);
		}
		Set<Entry<Integer, Integer>> entrySet = m.entrySet();
		for(Entry<Integer,Integer> map:entrySet) {
			if(map.getValue()>n/2) {
				return map.getKey();
			}
		}
		return 0;
	}

	private static int getMajorityElementsBrute(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
				if (count > n / 2) {
					return arr[i];
				}
			}
		}
		return 0;
	}

	private static void getMajorityElementsUsingStream(int[] arr, int n) {
		Entry<Integer, Long> entry = Arrays.stream(arr).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).get();
		System.out.println("1: "+entry);
	}
}
