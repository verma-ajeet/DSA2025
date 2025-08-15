import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
	public static void main(String[] args) {
		int arr[] = { 11,2, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
	}

	private static void printNGE(int[] nums, int n) {
	       int[] result = new int[nums.length];
	        Stack<Integer> stack = new Stack<>();

	        for (int i = 0; i < nums.length; i++) {
	            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
	            	System.out.println(nums[i]+" "+stack.peek()+" "+nums[stack.peek()]);
	                int index = stack.pop();
	                result[index] = nums[i];
	            }
	
	            stack.push(i);
	            System.out.println(stack);
	        }

	        while (!stack.isEmpty()) {
	            int index = stack.pop();
	            result[index] = -1;
	        }

	        System.out.println(Arrays.toString(result));
//	        return result;
	}
}
//AA!ne#5732 
//Aac!ne#5732

