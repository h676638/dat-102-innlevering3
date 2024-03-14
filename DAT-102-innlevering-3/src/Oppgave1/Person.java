package Oppgave1;

public class Person {
	String name;
	String[] hobbies;
	public Person(String navn, String ... hobbyer) {
		this.name = navn;
		this.hobbies = hobbyer;
	}
}
