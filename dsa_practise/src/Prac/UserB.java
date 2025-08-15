package Prac;

public class UserB {
	private final String name;
	private final int id;
	private final String department;
	private final int age;

	public UserB(UserBuilder builder) {
		super();
		this.name = builder.name;
		this.id = builder.id;
		this.department = builder.department;
		this.age = builder.age;
	}

	public static class UserBuilder {
		private final String name;
		private final int id;
		private String department;
		private int age;

		public UserBuilder(String name, int id) {
			super();
			this.name = name;
			this.id = id;
		}

		public UserBuilder setDepartment(String department) {
			this.department = department;
			return this;
		}

		public UserBuilder setAge(int age) {
			this.age = age;
			return this;
		}

		public UserB build() {
			return new UserB(this);
		}
	}
	public static void main(String[] args) {
		UserB user = new UserB.UserBuilder("Alice", 101)
                .setDepartment("IT")
                .setAge(30)
                .build();
	}
}
