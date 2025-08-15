package recursion;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StudentPrac {
    private String name;
    private int score;
	public StudentPrac(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
    
}

public class Student_prac {
	public static void main(String[] args) {
      List<StudentPrac> list=Arrays.asList(
              new StudentPrac("Alice", 90),
              new StudentPrac("Eve", 85),
              new StudentPrac("Charlie", 95),
              new StudentPrac("David", 88),
              new StudentPrac("Eve", 92),
              new StudentPrac("Eve", 93)
      );
      list.stream().sorted(Comparator.comparing(StudentPrac::getScore,Comparator.reverseOrder())).limit(3).forEach(System.out::println);
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
      int sumOfSquares = numbers.stream()
                                .map(x -> x * x)
                                .reduce(0, Integer::sum);
      System.out.println(sumOfSquares);
      List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
      names.stream().filter(name->name.length()>5).forEach(System.out::println);
      String s="ajeet";
      List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
      Set<Integer> set= new HashSet<>();
      myList.stream().filter(num->!set.add(num)).forEach(System.out::println);
      System.out.println("------------------------------------");
      list.stream().sorted(Comparator.comparing(StudentPrac::getName).thenComparing(StudentPrac::getScore,Comparator.reverseOrder())).forEach(System.out::println);
      System.out.println("------------------------------------");
      list.stream().sorted(Comparator.comparing(StudentPrac::getName).thenComparing(StudentPrac::getScore).reversed()).forEach(System.out::println);
      System.out.println("------------------------------------");
      list.stream().sorted(Comparator.comparing(StudentPrac::getScore).reversed().thenComparing(StudentPrac::getName)).forEach(System.out::println);
      System.out.println("------------------------------------");
      
	}
}
































