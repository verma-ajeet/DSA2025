package Linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Employee {
	private String name;
	private String city;
	private int age;
	private double salary;

	public Employee(String name, String city, int age, double salary) {
		this.name = name;
		this.city = city;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public int getAge() {
		return age;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", city=" + city + ", age=" + age + ", salary=" + salary + "]";
	}

	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Doe", "Berlin", 25, 12000),
				new Employee("John", "Sydney", 22, 9000),
				new Employee("Mary", "Berlin", 29, 13000),
				new Employee("Adams", "London", 34, 10500),
				new Employee("Adams", "London", 32, 11500),
				new Employee("Harry", "Berlin", 35, 12000));
		Employee employee = employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
		System.out.println(employee.getAge());
		DoubleSummaryStatistics collect = employees.stream().collect(Collectors.summarizingDouble(Employee::getAge));
		System.out.println(collect.getAverage());
		System.out.println(collect.getMax());
		System.out.println(collect.getMin());
		DoubleSummaryStatistics collect2 = IntStream.range(0, 10).boxed().collect(Collectors.summarizingDouble(i->i));
		System.out.println(collect2.getMax());
		System.out.println(collect2.getMin());
		System.out.println(collect2.getSum());
		List<Integer> list=Arrays.asList(4,2,3,1,2);
		Double collect3 = list.stream().collect(Collectors.averagingInt(i->i));
		System.out.println(collect3);
		Predicate<Integer> p=(i)->i%2==0;
		for(int i=0;i<10;i++) {
			System.out.println("i = "+ i+" " +p.test(i));
		}
		employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparingDouble(Employee::getSalary)).forEach(System.out::println);
		
	}
}
