package DesignPattern;

public class SingletonPattern {
	public static SingletonPattern instance;

	private SingletonPattern() {

	}

	public static SingletonPattern getInstance() {
		System.out.println("instance ="+instance );
		if (instance == null) {
			instance = new SingletonPattern();
		}
		return instance;
	}

	public static void main(String[] args) {
		SingletonPattern s = new SingletonPattern();
		System.out.println(s.getInstance());
		SingletonPattern s1 = new SingletonPattern();
		System.out.println(s1.getInstance());
	}
}
