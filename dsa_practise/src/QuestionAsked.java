import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;import javax.security.auth.callback.CallbackHandler;

public class QuestionAsked {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps right over the little lazy dog";
		Arrays.stream(str.split(" ")).map(String::toUpperCase)
		.filter(
				w->
				{
					boolean count=Arrays.stream(w.split(""))
						 .filter(c->"AEIOU".contains(c)).count()==2;
					return count;
				}
				).forEach(System.out::println);
		getWordsWithTwoVowels(str.toUpperCase());
		String str1="abcdeabfexyz";
		String collect = Arrays.stream(str1.split("")).distinct().collect(Collectors.joining());
		System.out.println(collect);
		String collect2 = Arrays.stream(str1.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream().filter(map->map.getValue()==1 || map.getValue()==2).map(Map.Entry::getKey).collect(Collectors.joining());
		System.out.println(collect2);
		System.out.println("print number repeated many times");
		int[] arr= {2,5,31,5,6,3,48,5,6,3,2,5,4,};
		Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		.entrySet().stream()
		.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1)
		.forEach(System.out::println);
		getNumberRepetedMaxTime(arr);
		int[] arr1= {1,2,3,4,5};
		int[] arr2= {5,4,3,2,1};
		boolean checkArraysEqual = checkArraysEqual(arr1,arr2);
		System.out.println(checkArraysEqual);
		int checkArraysEqualUsingXor = checkArraysEqualUsingXor(arr1,arr2);
		if(checkArraysEqualUsingXor==0) {
			System.out.println("arrays are equal");
		}
		int arr3[] = { 11,2, 13, 21, 3 };
		printNextGreaterElement(arr3);
		System.out.println(Arrays.toString(arr3));
		printNextGreaterElementSelfPractice(arr3);
		String str2="I am interested123455 to grow in my organization";
		Optional<String> max = Arrays.stream(str2.split(" ")).max(Comparator.comparingInt(String::length));
		System.out.println(max.get());
		getWordWithMaxLength(str2);
		String str4="abc@gmail.com";
		reverseString(str4);
	}

	private static void printNextGreaterElementSelfPractice(int[] arr3) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<arr3.length;i++) {
        	while(!s.isEmpty() && arr3[i]>arr3[s.peek()]) {
        		arr3[s.pop()]=arr3[i];
        	}
        	s.push(i);
        }
        while(!s.isEmpty()) {
        	arr3[s.pop()]=-1;
        }
        System.out.println("Self Practice "+Arrays.toString(arr3));
	}

	private static void reverseString(String str4) {
		 char[] charArray = str4.toCharArray();
	        int left = 0;
	        int right = charArray.length - 1;
		int j=str4.length()-1;
		while(left<right) {
			if(!Character.isLetterOrDigit(charArray[left])) {
				left++;
			}else if(!Character.isLetterOrDigit(charArray[right])) {
				right--;
			}else {
				char temp=charArray[left];
				charArray[left]=charArray[right];
				charArray[right]=temp;
				left++;
				right--;
			}
		}
		str4=new String(charArray);
		System.out.println(str4);
	}

	private static void getWordWithMaxLength(String str2) {
		String wordWithMaxLength="";
		for(String word:str2.split(" ")) {
			if(word.length()>wordWithMaxLength.length()) {
				wordWithMaxLength=word;
			}
		}
		System.out.println(wordWithMaxLength);
	}

	private static void printNextGreaterElement(int[] arr) {
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!(s.isEmpty()) && arr[i]>arr[s.peek()]) {
				arr[s.pop()]=arr[i];
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			arr[s.pop()]=-1;
		}
		System.out.println(Arrays.toString(arr));
		
	}

	private static int checkArraysEqualUsingXor(int[] arr1, int[] arr2) {
		int xorArray1=0;
		int xorArray2=0;
		for(int i=0;i<arr1.length;i++) {
			xorArray1^=arr1[i];
			xorArray2^=arr2[i];
		}
		System.out.println(xorArray1^xorArray2);
		return xorArray1^xorArray2;
	}

	private static boolean checkArraysEqual(int[] arr1, int[] arr2) {
		return arr1.length==arr2.length?checkEqual(arr1,arr2):false;

	}

	private static boolean checkEqual(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		if(arr1.length==arr2.length) {
			int count=0;
			for(int i=0;i<arr1.length;i++) {
				for(int j=0;j<arr2.length;j++) {
					if(arr1[i]==arr2[j]) {
						count++;
					}
				}
				if(count==arr1.length) {
					return true;
				}
			}
		}
		return false;
	}

	private static void getNumberRepetedMaxTime(int[] arr) {
		int max=0;
		int num=0;
		for(int i=0;i<arr.length;i++) {
			int count=0;
			for(int j=0;j<arr.length;j++) {
				if(arr[i]==arr[j]) {
				     count++;
				 	 max = Math.max(count, max);
				 	 if(max==count) {
				 		 num=arr[i];
				 	 }
				}
			}
		}
		System.out.println(num +" repeated "+max+" times");
	}

	private static void getWordsWithTwoVowels(String str) {
		String[] words = str.split(" ");
		List<String> l=new ArrayList<>();
		for(String word:words) {
			int count=0;
			for(char ch:word.toCharArray()) {
				if("AEIOU".contains(ch+"")) {
					count++;
				}
			}
			if(count==2) {
				l.add(word);
			}
		}
		System.out.println(l);
	}
}
