package recursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class PrintWordsStartsWith {
	public static void main(String[] args) {
		String[] s = { "akash", "rahul", "nimesh", "roshan", "nikhil" };
		Arrays.stream(s).filter(w -> w.startsWith("n")).forEach(System.out::println);
		Stream<String> stream = Arrays.stream(s);
		System.out.println("=================================================");
		stream.sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.comparing(n->n))).forEach(System.out::println);
		System.out.println("=================================================");
		String wordWithHighestLength = Arrays.stream(s).max(Comparator.comparingInt(String::length)).get();
		System.out.println("wordWithHighestLength "+wordWithHighestLength);
		Map<Integer,String> m=new HashMap<>();
		m.put(1, "a");
		m.put(2, "s");
		m.put(3, "aa");
		m.put(4, "d");
		m.entrySet().stream().filter(k->k.getValue().equals("d")).forEach(System.out::println);
		System.out.println("=================================================");
		m.entrySet().stream().sorted(Map.Entry.comparingByValue()).filter(v->!v.getValue().startsWith("a")).forEach(System.out::println);
		int[] arr=new int[5];
		Arrays.fill(arr, -1);
		System.out.println(Arrays.toString(arr));
	}
}
