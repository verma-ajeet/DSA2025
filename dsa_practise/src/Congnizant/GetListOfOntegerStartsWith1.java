package Congnizant;

import java.util.Arrays;
import java.util.List;

public class GetListOfOntegerStartsWith1 {
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(11, 10, 20, 24, 85, 66, 13, 111);
		l.stream().filter(n->n%10==5).forEach(System.out::println);
		l.stream().filter(n->n.toString().endsWith("5")).forEach(System.out::println);
		l.stream().filter(n->n.toString().startsWith("1")).forEach(System.out::println);
//		List<Integer> collect = l.stream().filter(n -> String.valueOf(n).startsWith("1")).collect(Collectors.toList());
//		System.out.println(collect);
	}
}
