interface Greet{
	void wishThem(String input);
}

public class Greetings {
	public static void main(String[] args) {
		Greet greetMorning = (name) -> System.out.println("Good morning: "+name); 
		Greet greetEvening = (name) -> System.out.println("Good evening: "+name);
		
		greetMorning.wishThem("Nikhil");
		greetEvening.wishThem("Mungdo");
	}
}
