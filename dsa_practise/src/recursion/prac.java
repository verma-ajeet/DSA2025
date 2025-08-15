package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class prac {
	public static void main(String[] args) {
		String str = "The quick brown fox jumps right over the little lazy dog";
		IntStream chars = str.chars();
		str.chars().mapToObj(s -> (char) s);
		Arrays.stream(str.split(" ")).filter(s -> {
			long count = s.chars().mapToObj(ch -> (char) ch)      // maps character values to character object      
					.filter(word -> "aeiouAEIOU".contains(String.valueOf(word)))   // convert any type to string
					.count();
			return count == 2;
		}).forEach(System.out::println);
		Map<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(collect);
		Map<Character, Long> collect2 = str.chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Map<Character,Integer> map=new HashMap<>();
        str.chars().mapToObj(ch->(char)ch).forEach(character->map.put(character, map.getOrDefault(character,0)+1));
        System.out.println(map);
        Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        str.chars().mapToObj(ch->(char)ch).forEach(ch->map.put(ch, map.getOrDefault(ch, 0)+1));
        int[] arr1=new int[] {3,6,3,2,4,7};
        int[] arr2=new int[] {6,4,2,4,6,3};
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28,34);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        list1.stream().filter(list2::contains).forEach(System.out::println);
        Arrays.stream(arr1).distinct().filter(x->Arrays.stream(arr2).distinct().anyMatch(y->y==x))
        .boxed()
        .collect(Collectors.toList());
        String str1 = "Java Concept Of The Day";
        String collect3 = Arrays.stream(str1.split(" ")).map(w->new StringBuffer(w).reverse()).collect(Collectors.joining(" "));
        System.out.println(collect3);
        List<String> collect4 = Arrays.stream(str.split(" ")).map(String::toUpperCase).filter(w->{
        	long num=Arrays.stream(w.split("")).filter(ch->"AEIOU".contains(ch)).count();
        	return num==2;
        }).collect(Collectors.toList());
        System.out.println(collect4);
        Arrays.stream(str1.split(" ")).map(w->new StringBuilder(w).reverse()).forEach(System.out::println);
        int sum = IntStream.range(0, 10).sum();
        int[] array = new int[] {5, 1, 7, 3, 9, 6};
        int[] array2 = IntStream.rangeClosed(1, array.length).map(i->array[array.length-i]).toArray();
        System.out.println(Arrays.toString(array2));
        IntStream.range(1, array.length).map(i->array[array.length-i]).toArray();

        List<String> listOfStrings = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
        Map<String, Long> collect5 = listOfStrings.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        collect5.entrySet().stream().sorted((a,b)->Long.compare(b.getValue(),a.getValue())).limit(1).forEach(System.out::println);

        String s1 = "ROTATOR";
        String collect6 = Arrays.stream(s1.split("")).map(w->new StringBuffer(w).reverse()).collect(Collectors.joining());
	    System.out.println(collect6);
	    System.out.println(s1.equals(collect6));
//	    IntStream.range(0, s1.length()/2).
	}
}
