import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KthLargest {
    public static String findKthLargest(String[] nums, int k) {
//    	 A PriorityQueue is often used in scenarios where you want to maintain a collection 
//    	of elements in a way that allows quick access to the smallest (or largest) element.
    	List<String> collect = Arrays.stream(nums)
    	.sorted(Comparator.comparing(Integer::parseInt))
    	.collect(Collectors.toList());
    	System.out.println(collect);
    	System.out.println(collect.get(nums.length-k));
//        for (String num : nums) {
//            minHeap.offer(num);
//            if (minHeap.size() > k) {
//                minHeap.poll(); // pop the minimum value in the heap
//            }
//        }
//        System.out.println(minHeap);
    	List<String> sorted5 = Arrays.stream(nums).sorted(Comparator.comparing(Integer::parseInt)).collect(Collectors.toList());
    	System.out.println("parseint "+sorted5);
     	List<String> sorted4 = Arrays.stream(nums).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    	System.out.println("natural "+sorted4);
    	List<String> sorted2 = Arrays.stream(nums).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    	System.out.println("1= "+sorted2);
    	List<String> sorted3 = Arrays.stream(nums).sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
    	System.out.println("rev "+sorted3);
//    	It uses the Stream API to sort an array of strings based on their lengths in descending order,
//    	and if lengths are equal, it compares the strings in reverse order. 
//    	 you should use Integer.parseInt for comparison instead of comparing by length and lexicographically.
    	
//    	EXPLAINATION
//    	.sorted(...): This intermediate operation sorts the elements of the stream based on the provided comparator.
//
//    	Comparator.comparing(String::length): This comparator compares strings based on their lengths in ascending order.
//
//    	.reversed(): This reverses the order, so now the strings are sorted based on their lengths in descending order.
//
//    	.thenComparing(Comparator.reverseOrder()): This part of the comparator is applied when two strings have equal lengths. 
//    	It compares the strings in reverse lexicographical order.
    	List<String> sorted = Arrays.stream(nums).sorted(Comparator.comparing(String::length).reversed().thenComparing(Comparator.reverseOrder())).collect(Collectors.toList());
System.out.println(sorted);
    	Comparator<String> comparator = Comparator.comparing(String::length).reversed()
                 .thenComparing(Comparator.reverseOrder());
         
         Arrays.sort(nums, comparator);
         System.out.println(Arrays.toString(nums));
         System.out.println(nums[k-1]);
        return null;
    }

    public static void main(String[] args) {
        String[] nums = {"3", "6", "7", "20","10","1"};
        int k = 4;
        String kthLargest = findKthLargest(nums, k);
        System.out.println("Kth Largest Integer: " + kthLargest);
    }
	
}
