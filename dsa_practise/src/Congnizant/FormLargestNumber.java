package Congnizant;

import java.util.Arrays;

public class FormLargestNumber {
	public static void main(String[] args) {
		int[] arr = { 3, 30, 34, 5, 9 };
		String result = largestNumberOptimal(arr);
		System.out.println("Largest Number (Optimal): " + result);
	}

//  9534330
	private static String largestNumberOptimal(int[] arr) {
		String[] str = Arrays.stream(arr).mapToObj(Integer::toString).toArray(String[]::new);
		Arrays.sort(str,(a,b)->(b+a).compareTo(a+b));
		String result="";
		for(String s:str) {
			result=result+""+s;
		}
		return result;
	}

//	private static String largestNumberOptimal(int[] arr) {
//		String[] array = Arrays.stream(arr).mapToObj(Integer::toString).toArray(String[]::new);
//		Arrays.sort(array,(a,b)->(b+a).compareTo(a+b));
//		String result="";
//		for(String data:array) {
//			result=result+""+data;
//		}
//		return result;
//	}

//	private static String largestNumberOptimal(int[] arr) {
//		String[] str = Arrays.stream(arr).mapToObj(Integer::toString).toArray(String[]::new);
//		Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
//		String result = "";
//		for (String s : str) {
//			result = result + "" + s;
//		}
//		return result; //9534330
//	}

//	private static String largestNumberOptimal(int[] nums) {
//		String result = "";
//		String[] str = Arrays.stream(nums).mapToObj(Integer::toString).toArray(String[]::new);
//		Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));
//		System.out.println(Arrays.toString(str));
//		for (String data : str) {
//			result = result + "" + data;
//		}
//		System.out.println(result); // 9534330
//		return null;
//	}
}
