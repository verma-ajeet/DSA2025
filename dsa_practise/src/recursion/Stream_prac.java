package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
	int id;

	String name;

	int age;

	String gender;

	String department;

	int yearOfJoining;

	double salary;

	public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.department = department;
		this.yearOfJoining = yearOfJoining;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Id : " + id + ", Name : " + name + ", age : " + age + ", Gender : " + gender + ", Department : "
				+ department + ", Year Of Joining : " + yearOfJoining + ", Salary : " + salary;
	}
}

public class Stream_prac {
	public static void main(String[] args) {
		String s = "Hello, how are you today?";
		long count = Arrays.stream(s.split("")).filter(str -> "aeiouAEIOU".contains(str)).count();
		Map<String, Long> collect = Arrays.stream(s.split("")).filter(str -> "aeiouAEIOU".contains(str))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(collect);
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

//		Map<String, Long> collect2 = employeeList.stream()
//				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//		System.out.println(collect2);
//		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
//		Map<String, Double> collect3 = employeeList.stream()
//				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getAge)));
//		System.out.println(collect3);
//		Optional<Employee> collect4 = employeeList.stream()
//				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
//		System.out.println(collect4);
//		Map<String, Long> collect5 = Arrays.stream("ajeet".split(""))
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(collect5);
//		employeeList.stream().map(Employee::getName).sorted(Comparator.reverseOrder()).forEach(System.out::println);
//		String s1 = "neal";
//		String s2 = "lean";
//		char[] charArray = s1.toCharArray();
//		char[] charArray2 = s2.toCharArray();
//		Arrays.sort(charArray);
//		Arrays.sort(charArray2);
//		if (Arrays.equals(charArray, charArray2)) {
//			System.out.println("anagram");
//		} else {
//			System.out.println(charArray + " " + charArray2);
//			System.out.println("not anagram");
//		}
//		List<String> collect6 = employeeList.stream().filter(emp -> emp.getYearOfJoining() > 2015)
//				.map(Employee::getName).collect(Collectors.toList());
//		System.out.println(collect6);
//		Map<String, Long> collect7 = employeeList.stream()
//				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//		System.out.println(collect7);
//		Map<String, Double> collect8 = employeeList.stream().collect(
//				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//		System.out.println(collect8);
//		Optional<Employee> collect9 = employeeList.stream()
//				.filter(emp -> emp.getGender().equalsIgnoreCase("male")
//						&& emp.getDepartment().equalsIgnoreCase("product development"))
//				.collect(Collectors.minBy(Comparator.comparing(Employee::getAge)));
//		System.out.println(collect9);
//		Optional<Employee> collect10 = employeeList.stream()
//				.collect(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining)));
//		System.out.println(collect10);
//		Map<String, Long> collect11 = employeeList.stream()
//				.filter(emp -> emp.getDepartment().equalsIgnoreCase("sales and marketing"))
//				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
//		System.out.println(collect11);
//		Map<String, Double> collect12 = employeeList.stream()
//				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
//		System.out.println(collect12);
//		Map<String, List<Employee>> collect13 = employeeList.stream()
//				.collect(Collectors.groupingBy(Employee::getDepartment));
//		Set<Entry<String, List<Employee>>> entrySet = collect13.entrySet();
//		for(Entry<String, List<Employee>> e:entrySet) {
//			System.out.println(e.getKey());
//			System.out.println(e.getValue());
//		}
//		Optional<Employee> collect14 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
//	    System.out.println(collect14.get().getName()+" "+collect14.get().getAge()+" "+collect14.get().getDepartment());
//	    Map<Boolean, List<Employee>> collect15 = employeeList.stream().collect(Collectors.partitioningBy(emp->emp.getAge()<=25));
//        Set<Entry<Boolean, List<Employee>>> entrySet2 = collect15.entrySet();
//        for(Entry<Boolean,List<Employee>> emp:entrySet2) {
//        	System.out.println("----------------------------------");
//        	if(emp.getKey()) {
//        		System.out.println("emp age lesser than 25");
//        	}else {
//        		System.out.println("emp age greater than 25");
//        	}
//        	System.out.println("----------------------------------");
//        	List<Employee> value = emp.getValue();
//        	for(Employee e:value) {
//        		System.out.println(e);
//        	}
//        }
//        Optional<Employee> collect16 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
//        System.out.println(collect16);
        employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(1).forEach(System.out::println);
        Map<String, Long> collect2 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        collect2.entrySet().forEach(System.out::println);
        Map<String, Double> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(collect3);
        employeeList.stream().sorted(Comparator.comparingInt(Employee::getAge)).limit(1).forEach(System.out::println);
	}
}
