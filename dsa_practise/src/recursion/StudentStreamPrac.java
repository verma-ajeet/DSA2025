package recursion;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Student {
	String name;
	int id;
	String subject;
	double percentage;

	public Student(String name, int id, String subject, double percentage) {
		this.name = name;
		this.id = id;
		this.subject = subject;
		this.percentage = percentage;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public double getPercentage() {
		return percentage;
	}

	@Override
	public String toString() {
		return name + "-" + id + "-" + subject + "-" + percentage;
	}
}

public class StudentStreamPrac {
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();

		studentList.add(new Student("Paul", 11, "Economics", 78.9));
		studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
		studentList.add(new Student("Harish", 13, "History", 83.7));
		studentList.add(new Student("Xiano", 14, "Literature", 71.5));
		studentList.add(new Student("Soumya", 15, "Economics", 77.5));
		studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
		studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
		studentList.add(new Student("Mitshu", 18, "History", 73.5));
		studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
		studentList.add(new Student("Harry", 20, "History", 71.9));
		studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3)
				.forEach(System.out::println);
		Set<String> collect = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
		System.out.println(collect);
		Map<String, Double> collect2 = studentList.stream()
				.collect(Collectors.toMap(Student::getName, Student::getPercentage));
		collect2.entrySet().stream().forEach(System.out::println);
		List<Student> collect3 = studentList.stream().limit(3).collect(Collectors.toCollection(LinkedList::new));
		String collect4 = studentList.stream().map(Student::getName).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(collect4);
		Long collect5 = studentList.stream().collect(Collectors.counting());
		System.out.println(collect5);
		Optional<Student> collect6 = studentList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Student::getPercentage)));
		System.out.println(collect6);
		Optional<Student> collect7 = studentList.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Student::getPercentage)));
		System.out.println(collect7);
		DoubleSummaryStatistics collect8 = studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
		System.out.println(collect8);
		Map<String, List<Student>> collect9 = studentList.stream().collect(Collectors.groupingBy(Student::getSubject));
		collect9.entrySet().forEach(System.out::println);
		Map<Boolean, List<Student>> collect10 = studentList.stream().collect(Collectors.partitioningBy(stu->stu.getPercentage()>80.0));
		collect10.entrySet().forEach(System.out::println);
		Set<Entry<Boolean, List<Student>>> entrySet = collect10.entrySet();
		for(Entry<Boolean,List<Student>> stu:entrySet) {
			System.out.println("--------------------");
			if(stu.getKey()) {
				System.out.println("above 80");
			}
			else {
				System.out.println("below 80");
			}
			System.out.println("---------------------");
			for(Student s:stu.getValue()) {
				System.out.println(s);
			}
		}
	}
}
