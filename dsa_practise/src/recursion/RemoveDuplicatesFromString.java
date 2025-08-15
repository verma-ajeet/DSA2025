package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromString {
	public static void main(String[] args) {
		String test = "This sentence contains two words, one and two";
		Map<String, Long> collect = Arrays.stream(test.split(" "))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
		Set<String> set=new HashSet<>();
		Arrays.stream(test.split(" ")).filter(w->!set.add(w)).forEach(System.out::println);
		String str="sentence";
		Set<Character> setChar=new HashSet<>();
//		Arrays.stream(str.split("")).filter(ch->!setChar.add(ch)).forEach(System.out::println);
		Map<String, Long> collect2 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	    collect2.entrySet().stream().filter(i->i.getValue()>2).forEach(System.out::println);
	    int[] arr=new int[] {5,3,6,2,1,4,3};
	    int[] array = Arrays.stream(arr)
        .sorted()
        .toArray();
	    List<Integer> collect3 = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
	    System.out.println(collect3);
	    
	    System.out.println(Arrays.toString(array));
	    String str1 = "abcd";
        String str2 = "cdab";
        System.out.println((str1+""+str1).contains(str2));
//        Arrays.stream(str1.split("")).

        int[] array1 = new int[] {5, 1, 7, 3, 9, 6};
        IntStream.range(1, array1.length).map(i->array1[array1.length-i]).toArray();
        
	}
}
