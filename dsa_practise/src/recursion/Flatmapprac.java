package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Institute {
	String instituteName;
	List<String> locations;

	public Institute() {
		super();
	}

	public Institute(String instituteName, List<String> locations) {
		super();
		this.instituteName = instituteName;
		this.locations = locations;
	}

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@Override
	public String toString() {
		return "Institute [instituteName=" + instituteName + ", locations=" + locations + "]";
	}

}

public class Flatmapprac {
	public static void main(String[] args) {
		List<Institute> instituteList = new ArrayList<>();
		instituteList.add(new Institute("IIM", Arrays.asList("Bangalore", "Ahmedabad", "Kozhikode", "Lucknow")));
		instituteList.add(new Institute("IIT", Arrays.asList("Delhi", "Mumbai", "Kharagpur")));
		instituteList.add(new Institute("NIFT", Arrays.asList("Hyderabad", "Mumbai", "Patna", "Bangalore")));
		instituteList.stream().map(Institute::getInstituteName).forEach(System.out::println);
		instituteList.stream().map(Institute::getLocations).forEach(System.out::println);
		List<String> collect = instituteList.stream().flatMap(i->i.getLocations().stream()).collect(Collectors.toList());
		List<String> collect2 = instituteList.stream().flatMap(ins->ins.locations.stream()).collect(Collectors.toList());
		System.out.println(collect2);
		collect2.stream().distinct().forEach(System.out::println);
	}
}
































