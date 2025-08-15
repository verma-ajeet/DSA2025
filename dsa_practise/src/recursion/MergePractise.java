package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergePractise {
	public static void main(String[] args) {
		HashMap<String, Integer> subjectToStudentCountMap1 = new HashMap<>();

		subjectToStudentCountMap1.put("Maths", 45);
		subjectToStudentCountMap1.put("Physics", 57);
		subjectToStudentCountMap1.put("Chemistry", 52);
		subjectToStudentCountMap1.put("History", 41);

		// Map-2

		HashMap<String, Integer> subjectToStudentCountMap2 = new HashMap<>();

		subjectToStudentCountMap2.put("Economics", 49);
		subjectToStudentCountMap2.put("Maths", 42);
		subjectToStudentCountMap2.put("Biology", 41);
		subjectToStudentCountMap2.put("History", 55);

		HashMap<String, Integer> subjectToStudentCountMap3 = new HashMap<>(subjectToStudentCountMap1);
		subjectToStudentCountMap2.forEach((k, v) -> subjectToStudentCountMap3.merge(k, v, (v1, v2) -> v1 + v2));
		subjectToStudentCountMap3.entrySet().forEach(System.out::println);
		String str="ROTATOR";
		String str1="ROTTAOR";
		boolean allMatch = IntStream.range(1, str.length()/2).allMatch(i->str.charAt(i)==str.charAt(str.length()-i-1));
		System.out.println(allMatch);
		String collect = Arrays.stream(str.split("")).map(w->new StringBuffer(w).reverse()).collect(Collectors.joining());
		System.out.println(collect);
		String collect2 = Arrays.stream(str.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.out.println(collect2);
		String collect3 = Arrays.stream(str1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		System.err.println(collect2.equals(collect3));
	}
}
