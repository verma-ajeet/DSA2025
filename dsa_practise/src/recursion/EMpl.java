package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EMpl {
	int empid;
	String emp;

	public EMpl(int empid, String emp) {
		super();
		this.empid = empid;
		this.emp = emp;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "EMpl [empid=" + empid + ", emp=" + emp + "]";
	}
	public static void main(String[] args) {
		ArrayList<EMpl> list = new ArrayList<>();
		list.add(new EMpl(1,"abc"));
		list.add(new EMpl(2,"xyz"));
		list.add(new EMpl(5,"abc"));
		list.add(new EMpl(7,"rahul"));
		Map<String, List<EMpl>> collect = list.stream().collect(Collectors.groupingBy(EMpl::getEmp));
		collect.forEach((name, employeeList) -> {
	            System.out.println("Group: " + name);
	            System.out.println("Employees: " + employeeList);
	            System.out.println("-----------");
	        });
	}
}
