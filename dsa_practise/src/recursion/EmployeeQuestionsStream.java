package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employeee {
	private int id;
	private String name;
	private String dept;
	private long salary;
	public Employeee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employeee(int id, String name, String dept, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employeee [id=" + id + ", name=" + name + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
}

public class EmployeeQuestionsStream {
	public static void main(String[] args) {
      List<Employeee> list=new ArrayList<>();
      list.add(new Employeee(176,"Roshan","IT",600000));
      list.add(new Employeee(388,"Bikash","CIVIL",900000));
      list.add(new Employeee(470,"Bimal","DEFENCE",500000));
      list.add(new Employeee(624,"Sourav","CORE",400000));
      list.add(new Employeee(176,"Prakash","SOCIAL",1200000));
      List<Employeee> collect = list.stream().filter(e->e.getSalary()>500000).collect(Collectors.toList());
      collect.forEach(System.out::println);
      
	}
}




























