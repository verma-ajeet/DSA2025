package recursion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Duplicate {
	public static void main(String[] args) {
      List<Integer> list=Arrays.asList(0,2,3,23,43,1,2,3,4,45,100);
      Set<Integer> s=new HashSet<>();
      list.stream().filter(num->!s.add(num)).forEach(System.out::println);
      list.stream().distinct().forEach(System.out::println);
      List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
      Map<Integer,Integer> wd=new HashMap<>();
      for(Integer num:numbers) {
        wd.put(num, wd.getOrDefault(num, 0)+1);
      }
      wd.entrySet().stream().filter(num->num.getValue()==1).forEach(System.out::println);
      wd.forEach((key,value)->{
    	  System.out.println("key "+key+" value "+value);
      });
      System.out.println("List with duplicates removed: " + wd);

	}
}
