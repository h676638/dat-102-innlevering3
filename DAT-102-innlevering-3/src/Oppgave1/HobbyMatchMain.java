package Oppgave1;

public class HobbyMatchMain {
	static double match(Person a, Person b) {
		double felles = 0;
		double indA = 0;
		double indB = 0;
		for (int i = 0; i < a.hobbies.length; i++) {
			for (int j = 0; j < b.hobbies.length; j++) {
				if (a.hobbies[i].equals(b.hobbies[j])) {
					felles += 1;
				}
				
			}
		}
		indA = a.hobbies.length - felles;
		indB = b.hobbies.length - felles;
		return felles - (indA + indB) / (a.hobbies.length + b.hobbies.length);
	}
	public static void main(String args[]) {
		Person p1 = new Person("Arne", "jakt", "sykling", "venner", "data");
		Person p2 = new Person("Tom", "bowling", "sykling", "venner", "data", "trene");
		Person p3 = new Person("Sara", "shopping", "venner", "data");
		System.out.println(match(p1, p2));
		System.out.println(match(p2, p1));
		System.out.println(match(p1, p3));
		System.out.println(match(p3, p2));
	}
}
